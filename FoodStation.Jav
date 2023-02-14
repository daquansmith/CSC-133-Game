package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {
	private int capacity;
	private int color=setColor(ColorUtil.rgb(0, 255, 0)); 
	
	
	
	
	
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity() {
		this.capacity = this.getSize();
	} 
}
