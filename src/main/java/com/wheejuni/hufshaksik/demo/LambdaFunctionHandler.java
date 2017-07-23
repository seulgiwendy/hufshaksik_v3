package com.wheejuni.hufshaksik.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class LambdaFunctionHandler implements RequestHandler<JSONObject, JSONObject> {

    @Override
    public JSONObject handleRequest(JSONObject input, Context context) {
        context.getLogger().log("Input: " + input);
        
        
        String input_type = input.get("content").toString();
        
        
        
        // TODO: implement your handler
        return null;
    }

}
