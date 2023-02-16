package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject {
	
	public Fixed(int color) {
		super(color);
	}
	public Fixed(int color,int size) {
		super(color,size);
	}
	
	public void setLocation(Point location) {}
}
