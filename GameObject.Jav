package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

//abstract class for objects that are present in game world
public abstract class GameObject {
	
	private int size;//all objects have sizes 
	private int color; //all objects have colors
	private Point location; //all objects have a specific location
	
	//Getters and setters 
	public int getSize() {
		return size;
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	public Point getLocationx() {
		return location;
	}

	public void setLocation(Point location) {
		this.location=location; 
	}
	
}
