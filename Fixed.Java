package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject{
	//calling color
	public Fixed(int color) {
		super(color);
	}
	//constructor to call color and size
	public Fixed(int color,int size) {
		super(color,size);
	}
	//cannot set location of a fixed object
	public void setLocation(Point location) {}
}

