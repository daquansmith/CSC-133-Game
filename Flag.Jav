package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;


public class Flag extends Fixed{
	private int sequenceNumber;
	private int color=setColor(ColorUtil.rgb(0, 0, 255));  
	private int size=setSize(10); 

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	} 
}
