package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil; 


public class FoodStation extends Fixed {
	private int capacity;
	private int color; 

	public FoodStation() {
		this.capacity=getSize(); 
		setColor(0,255,0); 
	
	}
	
	
	public void setColor(int r, int g, int b) {
		this.color=ColorUtil.rgb(r, g, b);
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return super.getSize();
	}
	
	
	
}
