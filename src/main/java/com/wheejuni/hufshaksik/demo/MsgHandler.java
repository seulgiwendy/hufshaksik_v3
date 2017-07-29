package com.wheejuni.hufshaksik.demo;

import org.json.simple.JSONObject;
import org.json.simple.*;
import java.util.Calendar;
import java.util.Date;



public class MsgHandler {
	
	
	static int clock() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return hour;
	}
	
	static int day() {
		Calendar cal = Calendar.getInstance();
		//int hour = cal.get(Calendar.HOUR_OF_DAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}
	
	public static JSONObject readMessage(String message) throws Exception {
		int hour = MsgHandler.clock();
		JSONObject errorMsg = new JSONObject();
		errorMsg = CreateJSON.returnJSON("메뉴 로드 오류");
		
		
		if (day() == 7 || day() == 1) {
			
			JSONObject saturdayerror = CreateJSON.returnJSON("주말에는 서비스가 제공되지 않습니다. \n 다음 업데이트를 기다려주세요!");
			return MsgHandler.sendMessage(saturdayerror);
		}
		
		if (message.matches("인문관식당")) {
			Menu [] rawmenu = ParseMenu.returnInmunMenu();
			
			if (hour < 11) {
				JSONObject morning = CreateJSON.returnJSON(rawmenu[0].toString());
				return MsgHandler.sendMessage(morning);
			}
			
			else if (hour >= 11 && hour < 16) {
				
				JSONObject lunch = CreateJSON.returnJSON(rawmenu[1].toString() + rawmenu[2].toString() + rawmenu[3].toString());
				return MsgHandler.sendMessage(lunch);
			}
			
			else {
				JSONObject dinner = CreateJSON.returnJSON(rawmenu[4].toString());
				return MsgHandler.sendMessage(dinner);
			}
		}
		
		if (message.matches("교수회관식당")) {
			Menu [] rawmenugyosu = ParseMenu.returnGyosuMenu();
			if (hour < 11) {
				JSONObject morning = CreateJSON.returnJSON("교수회관식당은 아침을 제공하지 않습니다.");
				return MsgHandler.sendMessage(morning);
			}
			
			else if (hour >= 11 && hour < 16) {
				
				JSONObject lunch = CreateJSON.returnJSON(rawmenugyosu[0].toString());
				return MsgHandler.sendMessage(lunch);
			}
			
			else {
				JSONObject dinner = CreateJSON.returnJSON(rawmenugyosu[1].toString());
				return MsgHandler.sendMessage(dinner);
			}
			
			
		}
		
		if (message.matches("업데이트 일정 안내")) {
			
			JSONObject update = CreateJSON.returnJSON("외대학식알리미는 2학기 개강 일정에 맞춰 완전히 업데이트될 예정입니다. \n \n새로운 버전에서는 글로벌캠퍼스 지원을 포함한 다양한 기능이 추가될 예정입니다. 감사합니다!");
			return MsgHandler.sendMessage(update);
		}
		
		return errorMsg;
	}
	
	public static JSONObject sendMessage(JSONObject messageJSON) {
		JSONObject sendJSON = new JSONObject();
		
		sendJSON.put("message", messageJSON);
		sendJSON.put("keyboard", ReturnKeyboard.returnKeyset("init"));
		
		return sendJSON;
		
	}

}
