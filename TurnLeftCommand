package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
//Command to turn the ant left
public class TurnLeftCommand extends Command{
	private GameWorld gw; 
	
	public TurnLeftCommand(GameWorld gw) { 
		super("Turn Left"); 
		this.gw=gw; 
	}
	//Displays turn left info
	public void actionPerformed(ActionEvent e) { 
		gw.turnAntLeft();  
		System.out.println("Ant turn left invoked");
	}

}
