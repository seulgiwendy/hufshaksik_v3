package com.wheejuni.hufshaksik.demo;
import org.json.simple.*;


public class CreateJSON {
	
	static JSONObject returnJSON(String originalMenu) {
		JSONObject returnjson = new JSONObject();
		JSONObject text = new JSONObject();
		
		String messagetext = originalMenu;
		
		
		returnjson.put("text", messagetext);
		return returnjson;
	}

}
