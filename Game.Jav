package com.mycompany.a1;
import com.codename1.ui.Form;

public class Game extends Form {
	private GameWorld gw; 
	
	public Game() {
		gw =new GameWorld(); 
		gw.init();
		play(); 
	}

}

