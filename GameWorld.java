package com.mycompany.a3;
import java.util.Random;
import java.util.Observable;
import com.codename1.charts.models.Point; 
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
public class GameWorld extends Observable  {
	private int clock;
	private GameWorldCollection listOfObjects;
	private static int gameHeight = 1000;
	private static int gameWidth = 1000;
	Random random = new Random();
	private boolean pause;
	private boolean position;
	private boolean soundOn;
	private Sound FlagSnd;
	private Sound FoodStationSnd;
	private Sound lifeSnd;
	private BGSound BgSnd;
	
	// Initialize the game
	public void init() {
		this.clock = 0;
		pause = false;
		this.soundOn = false;
		listOfObjects = new GameWorldCollection();
		position = false;
		addAllObjects();
		
		
		this.setChanged();
		this.notifyObservers(this);
	}
	 //Adding GameObjects to the GameWorld
	public void addAllObjects() {
		
		int flag = 10;
		int foodstation = 4;
		int spiders=3;
		
		listOfObjects.add(Ant.getAnt(this));

		for (int i = 1; i < flag; i++) {
			listOfObjects.add(new Flag(i,this));
		}
		for (int i = 0; i < foodstation ; i++) {
			listOfObjects.add(new FoodStation(this));
		}
		for (int i = 0; i < spiders; i++) {
			listOfObjects.add(new Spider(this));
		}
	}

	

// Game Play Methods

	
	// Press 'a'
	public void increaseSpeed() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant)
			{
				((Ant)tempObject).accelerateSpeed();
			}
		}
		this.setChanged();
		this.notifyObservers(this);

	}
	// Press 'b'
	public void decreaseSpeed() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant)
			{
				((Ant)tempObject).decreaseAntSpeed();
			}
		}
		this.setChanged();
		this.notifyObservers(this);

	}
	// Press'l'
	public void turnAntLeft() {

		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant)
			{
				((Ant)tempObject).steerAntLeft();
			}
		}
		this.setChanged();
		this.notifyObservers(this);

	}
	// Press 'r'
	public void turnAntRight() {

		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant){
				((Ant)tempObject).steerAntRight();
			}
		}
		
		this.setChanged();
		this.notifyObservers(this);

	}
	
	
	// Press 't'
	public void tick(int time)
	{
		clock++;
		
		IIterator itr = listOfObjects.getIterator();
		
		while(itr.hasNext()){
			GameObject tempObject = itr.getNext();
			if (tempObject instanceof Ant) {
				if (((Ant) tempObject).getFoodLevel() >= 0 && ((Ant) tempObject).getHealthLevel()!=0 ) {
					((Ant) tempObject).move(time);
					((Ant) tempObject).foodLevelTick();
					
					IIterator itr3 = listOfObjects.getIterator();
					while(itr3.hasNext()){
						GameObject tempObject_3 = itr3.getNext();
						if (tempObject_3 instanceof Spider) {
							((Spider) tempObject_3).spiderMove(); 
							((Spider) tempObject_3).move(time);
							}
					 }
				}
				else if (((Ant) tempObject).getLives() != 0 ) {				
					System.out.println("You have lost 1 life");
					exit(3);
					
					int temp_last_base = ((Ant) tempObject).getLastFlagReached();
					
					IIterator itr_2 = listOfObjects.getIterator();
					while(itr_2.hasNext()){
						
						GameObject tempObject_2 = itr_2.getNext();
						
						if (tempObject_2 instanceof Flag){
								if (temp_last_base == (((Flag) tempObject_2).getSequenceNumber())){
									float flag_x = (((Flag) tempObject_2).getX());
									float flag_y = (((Flag) tempObject_2).getY());
									((Ant) tempObject).antReset((int)flag_x,(int)flag_y);
										if (getSound())
											lifeSnd.play();
								}
								
							}
						}
				}
				else {
					exit(2);
				}
				
		    
		}
	}
		checkForCollisions();
		if (getSound()) {
			BgSnd.play();
		}
		this.setChanged();
		this.notifyObservers(this);
	}
	
	//Check collision
	public void checkForCollisions() {
		IIterator iter = listOfObjects.getIterator();
		
		while(iter.hasNext()) {
			GameObject tempObject = iter.getNext();
			IIterator iter2 = listOfObjects.getIterator();
			
			while(iter2.hasNext()) {
				GameObject tempObject2 = iter2.getNext();
				if (tempObject!=tempObject2) {
					
					if(tempObject.collidesWith(tempObject2)) {
						
						if (tempObject instanceof Ant && tempObject2 instanceof Spider) {
							if (getSound())
								lifeSnd.play();
						}
						else if (tempObject instanceof Ant && tempObject2 instanceof Flag) {
							if (getSound())
								FlagSnd.play();
						}
						else if (tempObject instanceof Ant && tempObject2 instanceof FoodStation) {
							if (getSound())
								FoodStationSnd.play();
						}
						tempObject.handleCollision(tempObject2);
					}
				}
			}
		}
	} 
		
	
	// Set Sound
	public void setSound(boolean s) {
		this.soundOn = s;
		this.setChanged();
		this.notifyObservers(this);
	}
	public boolean getSound() {
		return soundOn;
	}
	// Press 'm'
	public void printMap() {
		
		System.out.println("Map is printed");
		IIterator iter = listOfObjects.getIterator();
		while(iter.hasNext()) {
			System.out.println(((GameObject)iter.getNext()).toString());
			
		}
		System.out.println("---------------------------");
	}


	// Press 'x' 
	// Get life from GameWorld for ScoreView
	public GameWorldCollection getCollection() {
		return listOfObjects;
	}

	public int getLife() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext()) {
			GameObject gameObject = (GameObject) itr.getNext();
			if (gameObject instanceof Ant)
			{
				return ((Ant)gameObject).getLives();
			}
		}
		return 0;

	}
	
//	// Get energyLevel from GameWorld for ScoreView
	public int getFoodLevel() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext()) {
			GameObject gameObject = (GameObject) itr.getNext();
			if (gameObject instanceof Ant)
			{
				return ((Ant)gameObject).getFoodLevel();
			}
		}
		return 0;

	}
//	
//	// Get Health from GameWorld for ScoreView
	public int getHealthLevel() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext()) {
			GameObject gameObject = (GameObject) itr.getNext();
			if (gameObject instanceof Ant)
			{
				return ((Ant)gameObject).getHealthLevel();
			}
		}
		return 0;

	}
//	// Get lastBaseReached from GameWorld for ScoreView
	public int getLastFlagReached() {
		IIterator itr = listOfObjects.getIterator();
		while(itr.hasNext()) {
			GameObject gameObject = (GameObject) itr.getNext();
			if (gameObject instanceof Ant)
			{
				return ((Ant)gameObject).getLastFlagReached();
			}
		}
		return 0;

	}
	
	// Processing Fixed Objects when we click on that
	public void click(Point clickPoint, Point originalPoint) {
		IIterator tempObject = listOfObjects.getIterator();
		while(tempObject.hasNext()) {
			if(tempObject.getNext() instanceof Fixed) {
				Fixed temp = (Fixed)tempObject.getCurrent();
				if(position && temp.isSelected()) {
					int newX = (int) (clickPoint.getX() - originalPoint.getX());
					int newY = (int) (clickPoint.getY() - originalPoint.getY());
					temp.setLocation(newX, newY);
					position = false;
					temp.setSelected(false);
				} else {	
					if(temp.contains(clickPoint, originalPoint)) 
						temp.setSelected(true);
					 else 
						temp.setSelected(false);
				}
			}
		}
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void addObject() {
		listOfObjects.add(new FoodStation(this));
	}
	public void loseLifeSound() {
		if (getSound())
			lifeSnd.play();
	}
	public GameWorldCollection getGameObjects() {
		return listOfObjects;
	}
	public static int getGameHeight() {
		return gameHeight; 
	}
	public static int getGameWidth() {
		return gameWidth;
	}
	public void setPause(boolean newPause) {
		pause = newPause;
	}
	public boolean getPause() {
		return pause;
	}
	public void positionOn() {
		if (position == true)
			position = false;
		else
			position = true;
	}
	public void exit(int number) {
		Command cOk = new Command("Ok");
		Command cOkLife = new Command("Ok");
		Command answer = new Command("");
		switch(number) {
		case 0:
			answer = Dialog.show("Congratulations!!!",  "You Win with the time is: " + this.getTime(), cOk);
			break;
		case 1:
			answer = Dialog.show("You have lost the game!!!!",  "Another cyborg has reached the last base!", cOk);
			break;
		case 2:
			answer = Dialog.show("You have lost the game!!!!",  "You Cyborg are out of lives!!!", cOk);
			break;
		case 3: 
			Dialog.show("ALERT!!!!",  "You have just lost 1 live !!!", cOkLife);
			break;
		}
		if(answer.equals(cOk)) {
			System.exit(0);
		}
	}
	
	public void disablePosition() {
		position = false;
	}
	public void createSound() {
		FlagSnd = new Sound("FlagSnd.wav");
		lifeSnd = new Sound("lifeSnd.wav");
		FoodStationSnd = new Sound("FoodStation.wav");
		BgSnd = new BGSound("BgSnd.wav");
	}
	public static void setGameWidth(int w) { gameWidth = w; }
	public static void setGameHeight(int h) { gameHeight = h; }
	
	public void turnOffSound() {
		BgSnd.pause();
	}
	public void turnOnSound() {
		if(getSound())
			BgSnd.play();
	}
	public int getTime() {
		return this.clock/100;
}

}
