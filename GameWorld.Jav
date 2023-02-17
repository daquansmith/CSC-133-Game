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
		this.spiderCount=0;
		this.flagCount=0;
		this.foodStationCount=0;
		this.endGame=false;
		addAllObjects(); 
	}
	
	//Using this method to add game obejects
	public void addAllObjects() {
		int foodStation=3; 
		int flag=4;
		int spiders=2; 
		
		for(int i=1;i<=flag;i++) {
			listOfObjects.add(new Flag(i));
			flagCount++; 
		}
		
		for(int i=1;i<=foodStation;i++) {
			listOfObjects.add(new FoodStation()); 
			foodStationCount++;
		}
		
		for(int i=0;i<spiders;i++) {
			listOfObjects.add(new Spider()); 
			spiderCount=0; 
			
		}
		listOfObjects.add(new Ant()); 
		antCount++; 
		
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
		
		for(int i=0;i<listOfObjects.size();i++) {
			((Ant)listOfObjects.get(i)).decreaseAntSpeed(); 
		}
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

