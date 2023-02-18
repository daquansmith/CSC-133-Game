package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
public class Game extends Form{
	private GameWorld gw; 
	private char key; //used to tell whether to quit the game or not
	public Game() {
		gw =new GameWorld(); 
		gw.init();
		play(); 
	}
    //Playing the Game 
	private void play() {
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		
		
		myTextField.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
					if(sCommand.length() != 0)
						switch (sCommand.charAt(0)) {
							//accelerate
							case 'a':
								gw.accelerateSpeed(); 
								break;
							//brake
							case 'b':
								gw.decreaseSpeed();
								break;
							//steer left
							case 'l':
								gw.turnAntLeft(); 
								break; 
							//steer right	
							case 'r':
								gw.turnAntRight(); 
								break; 
							//ints 1-9 for food station 
							case '1' :
								gw.collisionFlag(1);
								break; 	
							case '2':
								gw.collisionFlag(2); 
								break;
							case '3':
								gw.collisionFlag(3);
								break; 
							case '4':
								gw.collisionFlag(4);
								break; 
							case '5':
								gw.collisionFlag(5);
								break; 
							case '6':
								gw.collisionFlag(6);
								break; 
							case '7':
								gw.collisionFlag(7);
								break; 
							case '8':
								gw.collisionFlag(8);
								break; 
							case '9':
								gw.collisionFlag(9);
								break; 
							//foos station collision 
							case 'f':
								gw.collisionFoodStation();
								break; 
							//same location as spider
							case 'g':
								gw.spiderCollision(); 
								break; 
							//game tick
							case 't':
								gw.tick();
								break;
							//display the stats
							case 'd':
								gw.display();
								break;
							//display the map
							case 'm':
								gw.map();
								break;
							//Exit game? 
							case 'x':
								setKey(sCommand.charAt(0)); 
								System.out.println("Would you like to quit the game?");
								break;
							//continue game
							case 'N':
							case 'n':
								if(getKey()=='x') {
									System.out.println("Continue Game");
								}else {
									System.out.println("invalid"); 
								}
								break; 
							//exit
							case 'Y':
							case 'y':
								if(getKey()=='x') {
									gw.exit(); 
								}else {
									System.out.println("Invalid");
								}
								break;
							//invalid input
							default:
								System.out.println("\nInput is incorrect"); 
						}
			}
		}
	    );
}
	//getters and setters for key
	public void setKey(char key) {
		this.key=key; 
	}
	
	public char getKey() {
		return this.key; 
	}
}
