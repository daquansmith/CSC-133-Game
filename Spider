package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics; 
//Spider object class
public class Spider extends Moveable implements IDrawable{
	public Spider(GameWorld gw) {
		super(ColorUtil.rgb(0,0,0),gw);
		final int MINIMUM_SIZE=30;
		final int MAXIMUM_SIZE=60; 
		super.setHeading(rndm.nextInt(360));
		super.setSpeed(rndm.nextInt(2)); 
		super.setSize(new Random().nextInt(MAXIMUM_SIZE-MINIMUM_SIZE)+MINIMUM_SIZE); 
	}
	
	public void setSize(int size) {}; 
	
	
	public void setColor(int color) {};
	//different movement of spider
	public void spiderMove() {
		this.setHeading(super.getHeading()+rndm.nextInt(5)); 
	}
	//spider to string
	public String toString() {
		String parentString=super.toString(); 
		String spiderString=" Size= "+ getSize(); 
		String displayString ="Spider:"+parentString+spiderString; 
		return displayString; 
	}

	@Override
	public void handleCollision(GameObject other) {
		if(this instanceof Spider && other instanceof Ant) { 
			//this.getGw().spiderCollision();
		}
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.BLACK);
		int x=(int) ((int)this.getX() + pCmpRelPrnt.getX()); 
		int y=(int) ((int)this.getY() + pCmpRelPrnt.getY());
		
		int[] pointsX = {x,(x-10),(x+30),x}; 
		int[] pointsY= {(y+30),(y-30),(y-30),(y+30)}; 
		
		int nPoints=3; 
		g.drawPolygon(pointsX, pointsY, nPoints);
		
	}
}
