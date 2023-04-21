package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithFoodStationCommand extends Command{
	private GameWorld gw; 
	//This is supposed to be the command for collision with food station
	public CollideWithFoodStationCommand(GameWorld gw) { 
		super("Collision with Food Station"); 
		this.gw=gw; 
	}
	
	public void actionPerformed(ActionEvent e) { 
		gw.collisionFoodStation();
		System.out.println("Collision with food station invoked");
	}
	
}
