package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil; 

public class Flag extends Fixed{
	private int sequenceNumber;
	//default flag constructor
	public Flag(int sequenceNumber) {
		super(ColorUtil.rgb(0, 0, 255),10); 
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

}
