package com.mycompany.a3;

import java.util.ArrayList; 

public class GameWorldCollection implements ICollection {
	private ArrayList<GameObject> listOfGameObjects; 
	
	//instantiating the game world collection
	public GameWorldCollection () {
		listOfGameObjects =new ArrayList<GameObject>(); 
		
	}
	
	//Using the iterator method in order to iterate through the list of objects
	private class GameWorldIterator implements IIterator{ 
		//setting an index for the iterator
		private int index; 
	
		public GameWorldIterator() { //constructor 
			index = -1; 
		}

		@Override
		public boolean hasNext() {
			if(listOfGameObjects.size()<= 0) {//return false if there is no objects
				return false; 
			}
			
			if(index == listOfGameObjects.size() - 1) {//return false if the index is equal to the size of the list
				return false;
			}
			//return true if none of those cases 
			return true;
		}

		@Override
		public GameObject getNext() {
			index++; //iteration of index
			
			return listOfGameObjects.get(index);//getting information from the next object
		}

		@Override
		public GameObject getCurrent() {//getting current value of the game object at the index
			return listOfGameObjects.get(index);
		}

		@Override
		public void remove(GameObject object) {//removing a game object
			listOfGameObjects.remove(object); 
		}
		
		
	}
	//Overridden add 
	public void add(GameObject object) {
		listOfGameObjects.add(object); 
	}
	//returning the iterator
	public IIterator getIterator() {
		return new GameWorldIterator(); 
	}

}
