package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command{
	private GameWorld gw; 
	//Command to accelerate the ant
	public AccelerateCommand(GameWorld gw) { 
		super("Accelerate"); 
		this.gw=gw; 
	}
	//Displays this output on press of button 
	public void actionPerformed(ActionEvent e) { 
		gw.increaseSpeed(); 
		System.out.println("Accelerate Speed Invoked");
	}
	

}

