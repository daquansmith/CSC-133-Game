package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
//Turning the ant right command
public class TurnRightCommand extends Command{
private GameWorld gw; 
	
	public TurnRightCommand(GameWorld gw) { 
		super("Turn Right"); 
		this.gw=gw; 
	}
	//turn right command info
	public void actionPerformed(ActionEvent e) { 
		gw.turnAntRight();  
		System.out.println("Ant turn right invoked");
	}


}
