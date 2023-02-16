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
	public int getSize() {
		return size;
	}
	
	public int getColor() {
		return color;
	}
	
	public float getX() {
		return location.getX(); 
	}
	
	public float getY() {
		return location.getY(); 
	}
	
	public void setColor(int color) {
		this.color=color;
		
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
		String displayString="Loc = "+location.getX() +","+ location.getY()+"Color = ["+ColorUtil.red(color) + ","+ColorUtil.green(color)+","+ ","+ColorUtil.blue(color)+"]" + "size = "+getSize(); ;
		return displayString;
	}
	

}
