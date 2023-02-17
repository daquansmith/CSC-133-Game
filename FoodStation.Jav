package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed{
	private int capacity;
	private int size=rndm.nextInt(50)+10;
	
	public FoodStation () {
		super(ColorUtil.rgb(0, 255, 0));
		super.setSize(size);
		this.capacity=this.size; 
		
	}
		
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity() {
		this.capacity = getSize();
	} 
	
	public void setCapacity(int food) {
		this.capacity=food; 
		
	}
	
	public String toString() {
		String parentString=super.toString(); 
		String foodStationString=" capacity: "+capacity; 
		String displayString ="Food Station:"+parentString+foodStationString; 
		return displayString; 
	}

}
	

