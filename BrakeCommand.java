package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command{
	private GameWorld gw; 
	//This command makes the ant slow down
	public BrakeCommand(GameWorld gw) {
		super("Brake"); 
		this.gw=gw; 
	}
	//Displays this when button is pressed
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeed();
		System.out.println("Decrease speed invoked"); 
	}

}
