package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Moveable extends GameObject{
	//attibutes 
			private int speed;
			private int heading;

			public Moveable (int color, GameWorld gw) {
				super(color, gw); 
			}

			public Moveable (int color,int size, GameWorld gw) {
				super(color,size, gw); 
			}
			//the move for a moveable Object
			public void move(int time) { 
				Point oldLocation;//old location before move
				Point newLocation;//new location after
				float angle;//Theta
				float deltaX;
				float deltaY;
				float elapsedTime=time; 
				float distX= speed*elapsedTime; 
				float distY=speed*elapsedTime; 
				
				//grabbing location of object 
				oldLocation =getLocation(); 
				//instantiating new location Point
				newLocation = new Point();

				//need a new angle due to the new baring
				angle = 90-getHeading();  
				deltaX = 0;
				deltaY = 0; 
				//casting to floats 
				deltaX=(float) (Math.cos(Math.toRadians(angle))*distX); 
				deltaY=(float) (Math.sin(Math.toRadians(angle))*distY); 
				int orginalX = (int)MapView.getMapViewOrigin().getX();
		 		int orginalY = (int)MapView.getMapViewOrigin().getY();
		 		
				if(deltaX+oldLocation.getX()>MapView.getMapViewWidth()) {
					deltaX=(deltaX-500); 
				}
				if(deltaY+oldLocation.getY()>MapView.getMapViewHeight()) {
					deltaY=(deltaY-500); 
				}
				
				if(deltaX+oldLocation.getX()<=orginalX) {
					deltaX=(deltaX+500); 
					
				}
				if(deltaY+oldLocation.getY()<=orginalY) { 
					deltaY=(deltaY+500); 
					
				}
				newLocation.setX(deltaX+oldLocation.getX());
				newLocation.setY(deltaY+oldLocation.getY());
				
		 		
			
			this.setLocation(newLocation);
			}
				//getters and setters 
				public int getSpeed() {
					return this.speed; 
				}
				public int getHeading() {
					return this.heading;
				}

			public void setSpeed(int speed) {
				this.speed=speed;
			}

			public void setHeading(int heading) {
				while(heading >= 360.0) {
					heading -= 360.0;
				} 
				while(heading < 0.0) {
					heading += 360.0;
				}
				this.heading = heading;
			}
			//overriden toString()
			public String toString() {
				String parentString =super.toString(); 
				String s= " Speed = "+speed+" Heading= "+heading;
				String displayString=parentString+s;
				return displayString; 
			}
	}
