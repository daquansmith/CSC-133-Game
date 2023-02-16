package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil; 

public class Flag extends Fixed{
	private int sequenceNumber;
	private int size; 
	
	public Flag(int sequenceNumber) {
		super(ColorUtil.rgb(0, 0, 255),10); 
		this.sequenceNumber=sequenceNumber; 
	
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getSize() {
		return size;
	} 
	
	public String toString() {
		String parentString=super.toString(); 
		String flagString=" seqNum: "+sequenceNumber; 
		String displayString ="Flag:"+parentString+flagString; 
		return displayString; 
	}

}
