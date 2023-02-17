package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {
	
	private int capacity;
	private int size;
	Random rndm;
	
	public FoodStation () {
		super(ColorUtil.rgb(0, 255, 0));
		this.size= rndm.nextInt(50)+10;
		this.capacity=size; 
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity() {
		this.capacity = getSize();
	} 
	
	public String toString() {
		String parentString=super.toString(); 
		String foodStationString=" capacity: "+capacity; 
		String displayString ="Flag:"+parentString+foodStationString; 
		return displayString; 
	}

}
