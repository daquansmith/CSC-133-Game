package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements ISteerable{
	private int maxSpeed; 
	private int foodLevel; 
	private int foodConsumptionRate;
	private int healthLevel; 
	private int lastFlagReached;
	private int size;
	
	public Ant() {
		super();
		size=20; 
		setFoodLevel(50); 
		setLastFlagReached(1);
		setMaxSpeed(100); 
		setFoodConsumptionRate(2); 
		setHealthLevel(10); 
		super.setLocation(200,300); 
	}
	
	
	public int getFoodLevel() {
		return foodLevel;
	}
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}

	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}

	public int getLastFlagReached() {
		return lastFlagReached;
	}

	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	} 
	
	public String toString() {
		String parentString=super.toString(); 
		String antString="maxSpeed: "+ getMaxSpeed() +" foodConsumptionRate: "+ getFoodConsumptionRate(); 
		String displayString ="Ant:"+parentString+antString; 
		return displayString; 
	}
	public void steer() {
		
		
		
	}
}
