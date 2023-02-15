package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable  {
	private int maxSpeed; 
	private int foodLevel; 
	private int foodConsumptionRate;
	private int healthLevel; 
	private int lastFlagReached;
	private int size;
	
	public Ant() {
		super(); 
		setColor(255,0,0);
		size=20; 
		setFoodLevel(50); 
		setLastFlagReached(1);
		setMaxSpeed(50); 
			
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
	
	
	
}

