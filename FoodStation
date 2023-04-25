package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;


public class FoodStation extends Fixed implements IDrawable {
	private int capacity;
	private int size=rndm.nextInt(100)+10;//using this for a random number
	private GameWorld gw; 
	//default food station constructor
	public FoodStation (GameWorld gw) {
		super(ColorUtil.rgb(0, 255, 0),gw);
		super.setSize(size);
		this.capacity=this.size; //size proportionate to capacity 
		
	}
	//getting capacity of food station 
	public int getCapacity() {
		return capacity;
	}
	//setting capacity of the food station 
	public void setCapacity() {
		this.capacity = getSize();
	} 
	//setting capacity after it has been collided with ant 
	public void setCapacity(int food) {
		this.capacity=food; 
		
		
	}
	//overriden to string for output
	public String toString() {
		String parentString=super.toString(); 
		String foodStationString=" capacity: "+capacity; 
		String displayString ="Food Station:"+parentString+foodStationString; 
		return displayString; 
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(super.getColor());
		
		int x= (int)this.getX()+(int)pCmpRelPrnt.getX(); 
		int y= (int)this.getY()+(int)pCmpRelPrnt.getY(); 
		g.fillRect(x, y, this.getSize(), this.getSize());
		
		if(super.isSelected()) {
			g.drawRect(x, y, this.getSize(), this.getSize()); 
		}else { 
			g.fillRect(x, y, this.getSize(),this.getSize());
		}
		g.setColor(ColorUtil.BLACK); 
		g.drawString(""+this.getCapacity(), x, y);
		
	}
	@Override
	public void handleCollision(GameObject other) {
		if (this instanceof FoodStation && other instanceof Ant) { 
			//this.getGw().collisionFoodStation(); 
		} 
		
	 }

}
