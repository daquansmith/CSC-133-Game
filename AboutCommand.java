package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

//This command helps when it comes to displaying about the program
public class AboutCommand extends Command {
	
	public AboutCommand() {
		super("About"); 
	}
	
	//Displaying about information 
	public void actionPerformed(ActionEvent e) { 
		String about = "StartToFinishGame\n"+"Professor Muyan\n"+"Made by Daquan Smith"
						+"Version 1"; 
		Dialog.show("About",about,"OK",null); 
	}

}
