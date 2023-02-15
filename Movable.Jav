package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class Moveable extends GameObject {

	//attibutes 
	private int speed;
	private int heading;
	 
	public Moveable() {
		super(); 
	}
	
	//the move for a moveable Object
	public void move() { 
		Point oldLocation;//old location before move
		Point newLocation;//new location after
		int angle;//Theta
		float deltaX;
		float deltaY;
		//grabbing location of object 
		oldLocation = getLocation(); 
		//instantiating new location Point
		newLocation = new Point();

		//need a new angle due to the new baring
		angle = 90-heading; 
		deltaX = 0;
		deltaY = 0; 
		//casting to floats 
		deltaX=(float) (Math.cos(angle)*speed); 
		deltaY=(float) (Math.sin(angle)*speed); 
		
	
		//changing values of x and y to be be new location
		newLocation.setX(deltaX+oldLocation.getX());
		newLocation.setY(deltaY+oldLocation.getY());
		
		//setting the location of the object using the location 
		setLocation(newLocation); 
		
	}	
		
	//getters and setters 
	public int getSpeed() {
		return this.speed; 
	}
	
	public int getHeading() {
		return this.heading;
	}
	
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public void setHeading(int heading) {
		this.heading=heading; 
	}
	//overriden toString()
	public String toString() {
		String parentString =super.toString(); 
		String s= "Speed = "+speed+" Heading= "+heading;
		
		String displayString=parentString+s;
		return displayString; 
	}
}
