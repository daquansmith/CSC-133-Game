package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	//Supposed to exit the game
	public ExitCommand() {
		super("Exit"); 
	}
	
	//Displaying exit information 
	public void actionPerformed(ActionEvent e) { 
		Command cOk =new Command("Yes"); 
		Command cCancel=new Command("Cancel"); 
		Command []cmds= new Command[] {cOk,cCancel};
		Command c =Dialog.show("Quit", "Do you want to quit?", cmds); 
		if (c==cOk) {
			System.exit(0); 
		}
		
	}

}
