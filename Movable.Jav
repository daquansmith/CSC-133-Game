package com.mycompany.a1;

import java.util.Random; 
import com.codename1.charts.util.ColorUtil; 

public class Spider extends Moveable{
	public Spider() {
		super(ColorUtil.rgb(0,0,0));
		final int MINIMUM_SIZE=10;
		final int MAXIMUM_SIZE=50; 
		super.setHeading(rndm.nextInt(360));
		super.setSpeed(rndm.nextInt(10)); 
		super.setSize(new Random().nextInt(MAXIMUM_SIZE-MINIMUM_SIZE)+MINIMUM_SIZE); 
	}
	//cannot set size later
	public void setSize(int size) {}; 
	//can set color later
	public void setColor(int color) {};
	//moving the spider the 5 degrees 
	public void spiderMove() {
		this.setHeading(super.getHeading()+rndm.nextInt(5)); 
	}
	//overriden to string 
	public String toString() {
		String parentString=super.toString(); 
		String spiderString=" Size= "+ getSize(); 
		String displayString ="Spider:"+parentString+spiderString; 
		return displayString; 
	}
}
