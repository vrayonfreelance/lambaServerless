package com.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class SimpleHttpHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        System.out.println(input.getBody());
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setBody("{\"name:\":\"Victor Daniel\"}");
        responseEvent.setStatusCode(200);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Custom-Header", "Hello World from Serverless!");
        responseEvent.setHeaders(headers);

        /*input.forEach((key, value) -> System.out.println(key + ":" + value));
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("statusCode", 418);
        response.put("body", "{\"name:\":\"Victor Daniel\"}");*/

        return responseEvent;
    }
}
