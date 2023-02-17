package com.mycompany.a1;

import java.util.Random; 
import com.codename1.charts.util.ColorUtil; 

public class Spider extends Moveable{

	public Spider() {
		super(ColorUtil.rgb(0,0,255));
		final int MINIMUM_SIZE=10;
		final int MAXIMUM_SIZE=50; 
		super.setHeading(rndm.nextInt(360));
		super.setSpeed(rndm.nextInt(10)); 
		super.setSize(new Random().nextInt(MAXIMUM_SIZE-MINIMUM_SIZE)+MINIMUM_SIZE); 
	}
	
	public void setSize(int size) {}; 
	
	public void setColor(int color) {};
	
	public void move() {
		this.setHeading(super.getHeading()+rndm.nextInt(5)); 
	}
	
}
