package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
//This is a command about the ticking of the clock
public class TickCommand extends Command {
	private GameWorld gw; 
	
	public TickCommand(GameWorld gw) {
		super("Tick"); 
		this.gw=gw; 
	}
	
	//Displaying tick information 
	public void actionPerformed(ActionEvent e) { 
		gw.tick(); 
		System.out.println("Game has Ticked"); 
		
	}

}
