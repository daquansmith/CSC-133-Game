package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random; 

//abstract class for objects that are present in game world
public abstract class GameObject {
	
	private Random rndm= new Random(); 
	private int size;//all objects have sizes 
	private int rgb; //all objects have colors
	private Point location; //all objects have a specific location
	//Game object constructor
	public GameObject() {
		float x= (float) ((float) (Math.round(1000.0* rndm.nextFloat()*10.0))/10.0);
		float y= (float) ((float) (Math.round(1000.0*rndm.nextFloat()*10.0))/10.0); 
	
		//In case the object gets too close to the edge we need to add this
		
		if(x>999) {
			x=999;
		}
		
		if (y>999) {
			y=999; 
		}
		
		//setting location 
		location = new Point (x,y); 
	}
	
	
	
	
	//Getters and setters 
	public int getSize() {
		return size;
	}
	//Using colorUtil??
	public int getColor() {
		return rgb;
	}
	
	public void setColor(int r,int g,int b) {
		
		
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location.setX((float) (((float)Math.round(location.getX())*10.0)/10.0)); 
		this.location.setY((float) (((float)Math.round(location.getY())*10.0)/10.0)); 
	}
	
    public void setLocation (float x, float y) {
    	
    }
	
}
