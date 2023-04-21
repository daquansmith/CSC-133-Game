package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command{
	public HelpCommand() {
		super("Help"); 
	}
	//This command tells the player each button that is needed to be pressed
	public void actionPerformed(ActionEvent e) {
		String help= "A: Accelerate\n"+
				     "B: Brake\n"+
				     "L: Turn Left\n"+
				     "R: Turn Right\n"+
				     "F: Collide with Food Station\n"+
				     "G: Collide with Spider\n"+
				     "T: Game Clock Tick"; 
		Dialog.show("Help Command",help,"Ok",null); 
	}
	

}
