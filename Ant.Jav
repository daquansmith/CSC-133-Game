package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements ISteerable{
	private int maxSpeed; 
	private int foodLevel; 
	private int foodConsumptionRate;
	private int healthLevel; 
	private int lastFlagReached;
	private int lives; 
	
	
	public Ant() {
		super(ColorUtil.rgb(255, 0, 0), 10);
		this.foodLevel=(50); 
		this.lastFlagReached=1;
		this.maxSpeed=100; 
		this.foodConsumptionRate=2; 
		this.healthLevel=10; 
		this.lives=3; 
		
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
	//Overrides the to String 
	public String toString() {
		String parentString=super.toString(); 
		String antString="maxSpeed: "+ getMaxSpeed() +" foodConsumptionRate: "+ getFoodConsumptionRate(); 
		String displayString ="Ant:"+parentString+antString; 
		return displayString; 
	}
	
	//steer left or right
	public void steer() {
		
	}
	
	public void turnAntRight() { 
		
	}
	
	public void turnAntLeft() {
		
	}


	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}

	//Accelerate speed of ant
	public void accelerateSpeed() {
		int currentSpeed= getSpeed(); 
		if(currentSpeed!=getMaxSpeed()) {
			this.setSpeed(currentSpeed);
		}
	}
		
	//Brake or decrease speed of ant
	public void decreaseAntSpeed() {
		int currSpeed=getSpeed(); 
		int negSpeed=currSpeed*-1;
		if(currSpeed>0) {
			this.setSpeed(negSpeed);
		}
	}
		
	//Taking food level down on every tick 
	public void foodLevelTick() {
		this.setFoodLevel(this.getFoodLevel()-this.getFoodConsumptionRate());
	}
		
}
