package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithSpiderCommand extends Command {
	private GameWorld gw; 
	// collision with spider command using game world
	public CollideWithSpiderCommand(GameWorld gw) { 
		super("Collision with Spider"); 
		this.gw=gw; 
	}
	
	public void actionPerformed(ActionEvent e) { 
		gw.spiderCollision();
		System.out.println("Collision with Spider Invoked");
	}
	
}
