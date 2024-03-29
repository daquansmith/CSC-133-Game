package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CollideFlagCommand extends Command {
	private GameWorld gw; 
	//This command is supposed to deal with the flag collisions
	public CollideFlagCommand(GameWorld gw) { 
		super("Collide with Flag"); 
		this.gw=gw; 
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Command ok=new Command("OK"); 
		TextField myTextField=new TextField(); 
		//Asks for the flag number 
		Dialog.show("Enter a Flag Number 1-9: ", myTextField, ok);
		
		String input= myTextField.getText().toString(); 
		//Changes the input to integer and uses it to find sequence number of flag
		int num= Integer.parseInt(input); 
		if (num>0 && num<10) {
			gw.collisionFlag(num);
			System.out.println("Collision with flag"); 
			
		}else{
			String again= "Please enter a number 1-9! "; 
			Dialog.show("Error",again, "Ok",null); 
			System.out.println("Enter a Flag Number 1-9"); 
		}
		
	}

}
