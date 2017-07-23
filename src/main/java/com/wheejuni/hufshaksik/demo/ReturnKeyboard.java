package com.wheejuni.hufshaksik.demo;

import org.json.simple.*;
import java.util.*;


public class ReturnKeyboard {
	
	public static JSONObject returnKeyset(String req) {
		JSONObject initkey = new JSONObject();
		JSONObject mealkey = new JSONObject();
		
		ArrayList<String> initKeyboard = new ArrayList<String>();
		initKeyboard.add("인문관식당");
		initKeyboard.add("교수회관식당");
		initKeyboard.add("업데이트 일정 안내");
		
		ArrayList<String> mealChoiceKeyboard = new ArrayList<String>();
		
		mealChoiceKeyboard.add("아침");
		mealChoiceKeyboard.add("점심");
		mealChoiceKeyboard.add("저녁");
		
		initkey.put("type", "buttons");
		initkey.put("buttons", initKeyboard);
		mealkey.put("buttons", mealChoiceKeyboard);
		
		
		if (req.matches("init")) {
			return initkey;
		}
		else {return mealkey;}
		
	}
	
	
	
	

}
