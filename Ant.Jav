package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.Point; 
public class Ant extends Moveable{
	private int maxSpeed; 
	private int foodLevel; 
	private int foodConsumptionRate;
	private int healthLevel; 
	private int maxHealth; 
	private int lastFlagReached;
	private int lives; 
	
	
	public Ant() {
		super(ColorUtil.rgb(255, 0, 0), 20);
		this.foodLevel=(30); 
		this.lastFlagReached=1;
		this.maxSpeed=50; 
		this.foodConsumptionRate=2; 
		this.healthLevel=10;
		this.maxHealth=10; 
		this.lives=3; 
		
	}
	public int maxHealth() {
		return this.maxHealth; 
	}
	public void setmaxHealth(int maxHealth) {
		this.maxHealth=maxHealth; 
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
	
	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}
	//Overrides the to String 
	public String toString() {
		String parentString=super.toString(); 
		String antString=" maxSpeed: "+ getMaxSpeed() +" foodConsumptionRate: "+ getFoodConsumptionRate(); 
		String displayString ="Ant:"+parentString+antString; 
		return displayString; 
	}
	
	//steer left or right
	public void steer(char c) {
		if (c=='l') {
			turnAntLeft();
		}
		if(c=='r') {
			steerAntRight(); 
		}
		
	}
	//Steer ant right
	public void steerAntRight() { 
		int current=this.getHeading(); 
		if(current==0) {
			current=current+5; 
			this.setHeading(current);
			if(this.getHeading()==0) {
				this.setHeading(current); 
				
			}else {
				this.setHeading(this.getHeading()+current);
			}
		}
 }
	//steer ant left
	public void turnAntLeft() {
		int current=this.getHeading(); 
		if(current==0) {
			current=current-5; 
			this.setHeading(current);
			if(this.getHeading()==0) {
				this.setHeading(current); 
				
			}else {
				this.setHeading(this.getHeading()+current);
			}
		}
		
	}


	//Accelerate speed of ant
	public void accelerateSpeed() {
		int currentSpeed= getSpeed(); 
		if(currentSpeed!=getMaxSpeed() && currentSpeed<maxSpeed) {
			this.setSpeed(currentSpeed+5);
		}else {
			System.out.println("Speed cannot go past max speed"); 
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
	
	//loses health points if makes a collision with a spider
	public void healthLoss (){
		healthLevel--; 
		
	}
	//checks the health level of the ant and makes adjustments too lives and maxSpeed if needed
	public void healthLevelCheck() {
		if(healthLevel>0 && healthLevel<maxHealth) {
			double healthLevelPercent=healthLevel/maxHealth; 
			setMaxSpeed((int)(healthLevelPercent*maxSpeed)); 
		}
		
		if (healthLevel==0) {
			this.setSpeed(0);
			lives--; 
		}
	}
		
	//Taking food level down on every tick 
	public void foodLevelTick() {
		this.setFoodLevel(this.getFoodLevel()-this.getFoodConsumptionRate());
	}

	//Resetting ant after it has ran out of food or lost a life
	public void antReset(float flagX, float flagY) {
		this.setLocation(new Point(flagX,flagY)); 
		this.setHeading(0);
		this.maxSpeed= 50; 
		this.foodConsumptionRate=2; 
		this.foodLevel=20;
		this.healthLevel=10; 
		lives--;
	}
		
}

