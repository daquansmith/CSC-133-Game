package com.mycompany.a1;

import com.codename1.charts.models.Point; 

public class Moveable extends GameObject {
	
	private int speed;
	private int heading; 
	
	
	public void move() {
		
		Point currlocation=getLocation(); 
		
		Point newLocation= new Point();
		
		int angle= 90-heading; 
		double deltaX=0;
		double deltaY=0; 
		
		
	}	
		
	
	
	
	
	
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
	
}
