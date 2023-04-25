package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics; 

public class Flag extends Fixed implements IDrawable{
	private int sequenceNumber;
	private GameWorld gw; 
	//default flag constructor
	public Flag(int sequenceNumber, GameWorld gw) {
		super(ColorUtil.rgb(0, 0, 255),100, gw); 
		this.sequenceNumber=sequenceNumber; 
	
		
	}
	//get sequence number
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	//setting sequence number
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	//getting size
	public int getSize() {
		return super.getSize();
	} 
	//Overriden to string 
	public String toString() {
		String parentString=super.toString(); 
		String flagString=" seqNum: "+sequenceNumber; 
		String displayString ="Flag:"+parentString+flagString; 
		return displayString; 
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(super.getColor());
		
		int x= (int) ((int)Math.round(this.getX()-10)+ pCmpRelPrnt.getX()); 
		int y= (int) ((int)Math.round(this.getY()-10)+ pCmpRelPrnt.getY()); 
		
		int locX=(int) ((int)this.getLocation().getX()+pCmpRelPrnt.getX()); 
		int locY=(int) ((int)this.getLocation().getY()+pCmpRelPrnt.getY()); 
		
		int[] xAxis= {locX,(locX-20),(locX +20),locX}; 
		int[] yAxis= {(locY+30),(locY-30),(locY-30),(locY+30)}; 
		int verticies=3; 
		
		
		
		if(super.isSelected()) {
			g.drawPolygon(xAxis,yAxis,verticies); 
		}else { 
			g.fillPolygon(xAxis, yAxis, verticies);
		}
		g.setColor(ColorUtil.BLACK); 
		g.drawString(""+this.sequenceNumber, x, y);
		
	}
	@Override
	public void handleCollision(GameObject other) {
		if(this instanceof Flag && other instanceof Ant) { 
			
		}
	}	
}
