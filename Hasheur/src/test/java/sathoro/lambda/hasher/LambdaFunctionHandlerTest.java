package sathoro.lambda.hasher;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private static String input;

    @BeforeClass
    public static void createInput() throws IOException {
        input = "";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Hahs mot de passe");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandlerHashing() {
        LambdaFunctionHandler handler = new LambdaFunctionHandler();
        Context ctx = createContext();

        HashMap<String, String> hashInput = new HashMap<String, String>();

        hashInput.put("input", "s3c3t");
        hashInput.put("type", "hash");

        ObjectMapper mapper = new ObjectMapper();

        try {
			input = mapper.writeValueAsString(hashInput);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

        System.out.println(input);

        String output = handler.handleRequest(input, ctx);

        // On ne vérifie pas l'égalité complète avec une chaîne car BCrypt
        // génère des chaînes différente pour la même entrée car l'algorithme
        // inclue un "salt" pour plus de sécurité.
        Assert.assertTrue(output.contains("$2a$10$"));
    }

    @Test
    public void testLambdaFunctionHandlerCheckingWithRightPassword() {
    	LambdaFunctionHandler handler = new LambdaFunctionHandler();
        Context ctx = createContext();

        HashMap<String, String> hashInput = new HashMap<String, String>();

        hashInput.put("input", "s3c3t");
        hashInput.put("hashed", "$2a$10$BCJF.eKdeIm5a1YYM4kdNuOQeP9OhGPTkKqlgTui3ER6d3VoJHu1O");
        hashInput.put("type", "check");

        ObjectMapper mapper = new ObjectMapper();

        try {
			input = mapper.writeValueAsString(hashInput);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

        String output = handler.handleRequest(input, ctx);

        Assert.assertEquals("valid", output);
    }

    @Test
    public void testLambdaFunctionHandlerCheckingWithWrongPassword() {
    	LambdaFunctionHandler handler = new LambdaFunctionHandler();
        Context ctx = createContext();

        HashMap<String, String> hashInput = new HashMap<String, String>();

        hashInput.put("input", "s3c3t");
        hashInput.put("hashed", "samarcherapa");
        hashInput.put("type", "check");

        ObjectMapper mapper = new ObjectMapper();

        try {
			input = mapper.writeValueAsString(hashInput);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

        String output = handler.handleRequest(input, ctx);

        Assert.assertEquals("error", output);
    }
}
