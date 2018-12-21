package sathoro.lambda.hasher;

import java.io.IOException;
import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaFunctionHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
    	ObjectMapper mapper = new ObjectMapper();

    	HashMap<String, String> parameters = null;

    	try {
    		parameters = mapper.readValue(input, HashMap.class);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

        if (parameters.get("type").equals("hash")) {
        	return BCrypt.hashpw(parameters.get("input"), BCrypt.gensalt());
        } else {
        	boolean result;
        	try {
        		result = BCrypt.checkpw(
    				parameters.get("input"),
    				parameters.get("hashed")
        		);
        	} catch (IllegalArgumentException e) {
        		result = false;
        	}

        	return result ? "valid" : "error";
        }
    }

}
