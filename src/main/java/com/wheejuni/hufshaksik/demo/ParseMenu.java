package com.wheejuni.hufshaksik.demo;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class ParseMenu {
	
public static int returnDate() {
		
		Calendar cal = Calendar.getInstance();
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMdd");
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int datecode = Integer.parseInt(sdf.format(d));
		
		return datecode;
	}
	
	public static int returnHour() {
		Calendar cal = Calendar.getInstance();
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMdd");
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//int datecode = Integer.parseInt(sdf.format(d));
		
		return hour;
		
	}
	
	public static Menu returnInmunMenu() throws Exception {
		String date = "170724";//Integer.toString(returnDate());
		String code = "011";
		
		int menucode = Integer.parseInt(date + code);
		int hour = returnHour();
		JSONObject menujson = returnRawMenus(menucode);
		Menu inmunMenu = new Menu(); 
		String uptime = menujson.get("frtime").toString() + " ~ " + menujson.get("totime").toString();
		String price = menujson.get("price").toString();
		
		inmunMenu.setMenu(menujson.get("rep_menu").toString(), menujson.get("menus").toString(), uptime, price, menujson.get("caf_name").toString(), hour );
		return inmunMenu;
	}
	
	public static Menu returnGyosuMenu() throws Exception {
		int menucode = 170724009;
		int hour = returnHour();
		
		Menu gyosuMenu = new Menu();
		JSONObject menujson = returnRawMenus(menucode);
		 
		String uptime = menujson.get("frtime").toString() + " ~ " + menujson.get("totime").toString();
		String price = menujson.get("price").toString();
		gyosuMenu.setMenu(menujson.get("rep_menu").toString(), menujson.get("menus").toString(), uptime, price, menujson.get("caf_name").toString(), hour);
		return gyosuMenu;
	}
	
	
	static JSONObject returnRawMenus(int menucode) throws Exception{
		
		HashMap <String, String> rawMenu = new HashMap<String, String>();
		String targetURL = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/m/detailMenu.jsp?menu_id=" + menucode;
		URL url = new URL(targetURL);
		
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		connect.setRequestMethod("GET");
		int responseCode = connect.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader (new InputStreamReader (connect.getInputStream(), "UTF-8"));
		}
		else { br = new BufferedReader (new InputStreamReader (connect.getErrorStream()));}
		
		String inputLine; 
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		
		String rawjson = response.toString();
		
		String processedjson = rawjson.replaceAll("\\]", "").replaceAll("\\[", "");
		JSONParser newparser = new JSONParser();
		JSONObject targetjson = (JSONObject)newparser.parse(processedjson);
		return targetjson;
	}



}
