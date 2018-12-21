package beans;

import java.nio.charset.StandardCharsets;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class LambdaFunction {
	public static String call(String funcName, String payload) {
		Regions region = Regions.fromName(Regions.US_EAST_1.getName());

		BasicAWSCredentials credentials= new BasicAWSCredentials("access key", "access id");

		AWSLambdaClientBuilder builder = AWSLambdaClientBuilder
											.standard()
											.withCredentials(new AWSStaticCredentialsProvider(credentials))
											.withRegion(region);

		AWSLambda client  = builder.build();
		InvokeRequest req = new InvokeRequest()
								.withFunctionName(funcName)
								.withPayload(payload);

		InvokeResult result = client.invoke(req);

		return StandardCharsets.UTF_8.decode(result.getPayload()).toString();
	}
}
