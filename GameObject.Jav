package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random; 

//abstract class for objects that are present in game world
public abstract class GameObject {
	public Random rndm= new Random(); 
	private int size;//all objects have sizes 
	private Point location; //all objects have a specific location
	private int color;//all objects have colors
	
	//abstract constructor
	public GameObject(int color) {
		this.color=color; 
		float x= (float) rndm.nextFloat()*1000;
		if(x>999) {
			x=999;
		}
	    float y= (float) rndm.nextFloat()*1000; 
	    if(y>999) {
	    	y=999; 
	    }
		this.location=new Point(x,y); 
	}
	
	//Abstract constructor
	public GameObject(int color, int size) {
		this.color=color; 
		this.size=size; 
		
		float x=(float)rndm.nextFloat()*1000;
		if(x>999) {
			x=999;
		}
		float y=(float)rndm.nextFloat()*1000; 
		if(y>999) {
	    	y=999; 
	    }
		this.location=new Point(x,y); 
	}
	
	//Getters and setters 
	//getting size 
	public int getSize() {
		return size;
	}
	//getting color
	public int getColor() {
		return color;
	}
	//get x for location 
	public float getX() {
		return location.getX(); 
	}
	//get y for location 
	public float getY() {
		return location.getY(); 
	}
	//set color of object
	public void setColor(int color) {
		this.color=color;
		
	}
	//set size of object
	public void setSize(int size) {
		this.size=size;
	}
	//Getting the location
	public Point getLocation() {
		return location;
	}
	//Setting the location
	public void setLocation(Point location) {
		this.location.setX((float) (((float)Math.round(location.getX())*10.0)/10.0)); 
		this.location.setY((float) (((float)Math.round(location.getY())*10.0)/10.0)); 
	}
	
	//ToString object override
	public String toString() {
		String displayString="Loc = "+Math.round((location.getX()*10.0)/10.0) +","+ Math.round((location.getY()*10.0)/10.0)+" Color = ["+ColorUtil.red(color) + ","+ColorUtil.green(color)+","+ColorUtil.blue(color)+"]" + " size = "+getSize(); ;
		return displayString;
	}
	

}
