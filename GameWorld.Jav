package com.mycompany.a1;

import java.util.ArrayList; 

public class GameWorld {
	ArrayList<GameObject> listOfObjects; 
	//attributes used to make the objects
	private int clock; 
	private int lives; 
	//the count of each object
	private int antCount; 
	private int flagCount; 
	private int foodStationCount; 
	private int spiderCount; 
	//Using this variable to end the game
	private boolean endGame; 
	
	public GameWorld() {
		init(); 
	}
	
	public void init() {
		listOfObjects=new ArrayList<GameObject>(); 
		this.clock=0; 
		this.antCount=0;
		this.flagCount=0;
		this.foodStationCount=0;
		this.endGame=false;
	}
	
	//Using this method to add game obejects
	public void addObject() {
		
	}
	
	//Game Methods
	
	//Accelerate 'a'
	public void accelerateSpeed() {
		System.out.println("Ant accelarates speed"); 
		
		for(int i=0;i<listOfObjects.size();i++) {
			if(listOfObjects.get(i) instanceof Ant) {
				((Ant)listOfObjects.get(i)).accelerateSpeed();
				
			}
			
		}
	}
	
	//Brake 'b'
	public void decreaseSpeed() {
		System.out.println("Ant decreases speed");
		
	}
	
	
	//Turn ant left 'l'
	public void turnAntRight() {
		
	}
	
	//Turn ant right 'r'
	public void turnAntLeft() {
		
	}
	
	//Ant collides with food station 'f'
	public void collisionFoodStation() {
		System.out.println("Ant collided with food station"); 
		
	}
	
	//Ant collides with spider 'g'
	public void spiderColliion() {
		
	}
	
	//Clock tick 't'
	public void tick() {
		
	}
	
	//Display the game stats 'd'
	public void display() {
		
	}
	
	//display the map of the objects in the game 'm'
	public void map() {
		
	}
	
	//Asking to end the game
	public void exit() {
		
	}
	
	//The person did not want to exit the game
	
	public void noExit() {
		
	}
	

}

