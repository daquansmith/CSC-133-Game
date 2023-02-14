package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Flag {
	private int sequenceNumber;
	private int color; 
	
	public Flag(int number) {
		setColor(0,0,255); 
		this.sequenceNumber=number; 
	}

	private void setColor(int r, int g, int b) {
		this.color= ColorUtil.rgb(r, g, b);
		
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	
}
