package com.wheejuni.hufshaksik.demo;

class Menu {
	

	String rep_menu, banchan, uptime;
	String price;
	String caf_name;
	int mealtime;
	
	public void setMenu(String rep_menu, String banchan, String uptime, String price, String caf_name, int mealtime) {
		
		this.rep_menu = rep_menu;
		this.banchan = banchan;
		this.uptime = uptime;
		this.price = price;
		this.caf_name = caf_name;
		this.mealtime = mealtime;
	}
	
	public String getMenu() {
		
		return this.rep_menu;
	}
	
	public String getBanchan() {
		
		return this.banchan;
	}
	
	public String getTime() {
		
		return this.uptime;
	}
	
	public String getPrice() {
		
		return this.price;
	}
	
	public String getCafName() {
		return this.caf_name;
	}
	
	public String getMealtime() {
		String mealtime = null;
		if (this.mealtime < 11) {
			mealtime = "아침";
		}
		else if (this.mealtime >= 11 && this.mealtime <= 15) {
			mealtime = "점심";
		}
		else {mealtime = "저녁";}
		return mealtime;
	}
}

