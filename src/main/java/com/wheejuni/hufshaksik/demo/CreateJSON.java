package com.wheejuni.hufshaksik.demo;
import org.json.simple.*;


public class CreateJSON {
	
	static JSONObject returnJSON(Menu originalMenu) {
		JSONObject returnjson = new JSONObject();
		JSONObject text = new JSONObject();
		
		String messagetext = originalMenu.toString();
		
		
		returnjson.put("message", messagetext);
		return returnjson;
	}

}
