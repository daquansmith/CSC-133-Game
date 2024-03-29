package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
//This command is for sound checkbox
public class SoundCommand extends Command {
	private GameWorld gw; 
	
	public SoundCommand(GameWorld gw) {
		super("Sound ON/OFF"); 
		this.gw=gw; 
	}
	
	//Displaying sound information 
	public void actionPerformed(ActionEvent e) { 
		if(((CheckBox) e.getComponent()).isSelected()) {
			gw.setSound(true);
		}else {
			gw.setSound(false);
		}
		
	}

}
