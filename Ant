package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point; 
public class Ant extends Moveable implements IDrawable{
	private int maxSpeed; 
	private int foodLevel; 
	private int foodConsumptionRate;
	private int healthLevel; 
	private int maxHealth; 
	private int lastFlagReached;
	private int lives; 
	private static Ant ant; 
	
	
	private Ant(GameWorld gw)  {
		super(ColorUtil.rgb(255, 0, 0), 50,gw);//making ant red and size 20
		this.foodLevel=(3000); //starts out at 30 food level 
		this.lastFlagReached=0;//first flag needed to be reached
		this.maxSpeed=50; //max speed to 50
		this.foodConsumptionRate=2; //consumption rate per tick 
		this.healthLevel=10;//health level of 10 before losing life
		this.maxHealth=10; //max health of the ant
		this.lives=3; // starts with three lives
		super.setHeading(rndm.nextInt(360));
		super.setSpeed(1);
		
	}
	//This is for singleton pattern
	
	public static Ant getAnt(GameWorld gw) {
		if (ant==null) {
			ant= new Ant(gw); 
			
		}
		return ant;
	}
	
	//get max health
	public int maxHealth() {
		return this.maxHealth; 
	}
	//set max health 
	public void setmaxHealth(int maxHealth) {
		this.maxHealth=maxHealth; 
	}
	//getting food level
	public int getFoodLevel() {
		return foodLevel;
	}
	//setting food level 
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	//getting food consumption 
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	//setting foos consumption 
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}
	//getting last flag reached
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	//setting last flag reached
	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}
	//get health level 
	public int getHealthLevel() {
		return healthLevel;
	}
	//set health level 
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	//get max speeed
	public int getMaxSpeed() {
		return maxSpeed;
	}
	//set maximum speed
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	} 
	//gets lives
	public int getLives() {
		return lives;
	}

	//sets lives
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
		//if l steer left
		if (c=='l') {
			steerAntLeft();
		}
		//if r steer right
		if(c=='r') {
			steerAntRight(); 
		}
		
	}
	//Steer ant right
	public void steerAntRight() { 
		int current=this.getHeading();  
		super.setHeading(current+35);
	}
 
	//steer ant left
	public void steerAntLeft() {
		int current=this.getHeading();
		super.setHeading(current-35);
		
	}


	//Accelerate speed of ant
	public void accelerateSpeed() {
		int currentSpeed= getSpeed(); 
		if(currentSpeed!=getMaxSpeed() && currentSpeed<maxSpeed) {
			super.setSpeed(currentSpeed+1);
		}else {
			System.out.println("Speed cannot go past max speed"); 
		}
	}
		
	//Brake or decrease speed of ant
	public void decreaseAntSpeed() {
		
		if(getSpeed()>0) {
			super.setSpeed(getSpeed()-1);
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
			lives--; 
		}
	}
	
		
	//Taking food level down on every tick 
	public void foodLevelTick() {
		this.setFoodLevel(this.getFoodLevel()-this.getFoodConsumptionRate());
	}

	//Resetting ant after it has ran out of food or lost a life
	public void antReset(float flagX, float flagY, GameWorld gw) {
		this.setLocation(new Point(flagX,flagY)); 
		this.setHeading(0);
		this.maxSpeed= 50; 
		this.foodConsumptionRate=2; 
		this.foodLevel=3000;
		this.healthLevel=10; 
		lives--;
	}
	

	@Override
	public void handleCollision(GameObject other) {
		
		
	}
	public void draw(Graphics g, Point pCmpRelPoint) {
		g.setColor(super.getColor());
		int x = (int)this.getX()+(int)pCmpRelPoint.getX(); 
		int y= (int)this.getY()+(int)pCmpRelPoint.getY(); 
		
		g.fillArc(x, y, this.getSize(), this.getSize(), 0, 360);
		
		g.setColor(ColorUtil.BLACK);
		
		
		
		
	}
		
}
