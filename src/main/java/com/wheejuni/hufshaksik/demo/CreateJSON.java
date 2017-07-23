package com.wheejuni.hufshaksik.demo;
import org.json.simple.*;


public class CreateJSON {
	
	static JSONObject returnJSON(Menu originalMenu) {
		JSONObject returnjson = new JSONObject();
		JSONObject text = new JSONObject();
		
		String messagetext = "오늘의 " + originalMenu.getCafName() + " " + originalMenu.getMealtime() + " 메뉴입니다." 
				+ "\n======================\n"
				+ originalMenu.getMenu()
				+ "\n(" + originalMenu.getBanchan() + ")"
				+ "\n" + originalMenu.getTime() + " / "+ originalMenu.getPrice();
		
		
		returnjson.put("message", messagetext);
		return returnjson;
	}

}
