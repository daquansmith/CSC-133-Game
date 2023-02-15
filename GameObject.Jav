package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random; 

//abstract class for objects that are present in game world
public abstract class GameObject {
	
	private Random rndm= new Random(); 
	private int size;//all objects have sizes 
	private Point location; //all objects have a specific location
	private int color;//all objects have colors
	
	public GameObject() {
		int color=ColorUtil.rgb(0,0,0); 
		int size=0; 
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
	
	public int getColor() {
		return color;
	}
	public void setColor(int R,int G, int B) {
		
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
		String displayString;
		
		return displayString="Loc = "+location.getX() +","+ location.getY()+"Color = ["
					  +ColorUtil.red(color) + ","+ColorUtil.green(color)+","
					  + ","+ColorUtil.blue(color)+"]" + "size = "+getSize(); 
	}
	
}

