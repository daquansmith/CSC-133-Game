package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class Moveable extends GameObject{
	//attibutes 
		private int speed;
		private int heading;
		 //calling just the color 
		public Moveable (int color) {
			super(color); 
		}
		//constructor calling size and color
		public Moveable (int color,int size) {
			super(color,size); 
		}
		
		
		//the move for a moveable Object
		public void move() { 
			Point oldLocation;//old location before move
			Point newLocation;//new location after
			float angle;//Theta
			float deltaX;
			float deltaY;
			//grabbing location of object 
			oldLocation =getLocation(); 
			//instantiating new location Point
			newLocation = new Point();

			//need a new angle due to the new baring
			angle = 90-getHeading(); 
			deltaX = 0;
			deltaY = 0; 
			//casting to floats 
			deltaX=(float) (Math.cos(Math.toRadians(angle))*this.getSpeed()); 
			deltaY=(float) (Math.sin(Math.toRadians(angle))*this.getSpeed()); 
			//changing to new location 
			newLocation.setX((float) (Math.round(deltaX+oldLocation.getX()*10.0)/10.0)); 
			newLocation.setY((float) (Math.round(deltaY+oldLocation.getX()*10.0)/10.0));
			
			//setting the location of the object using the location 
			setLocation(newLocation); 
			
		}	
			
		//getters and setters 
		
		//get Speed
		public int getSpeed() {
			return this.speed; 
		}
		//get heading
		public int getHeading() {
			return this.heading;
		}
		//set speed
		public void setSpeed(int speed) {
			this.speed=this.speed+speed;
		}
		//set heading 
		public void setHeading(int heading) {
			this.heading=heading; 
		}
		//overriden toString()
		public String toString() {
			String parentString =super.toString(); 
			String s= " Speed = "+speed+" Heading= "+heading;
			
			String displayString=parentString+s;
			return displayString; 
		}

	}
