package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {
	
	private int capacity;
	private int size;
	Random rndm;
	
	public FoodStation () {
		super();
		setColor(0,255,0);
		this.size= rndm.nextInt(50)+10;
		this.capacity=size; 
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity() {
		this.capacity = this.getSize();
	} 
	
	
	
	
}

