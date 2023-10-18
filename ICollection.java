package com.mycompany.a3;

public interface ICollection {
	//adding new game object
	public void add(GameObject object); 
	
	//Retuning Itterator before going through collection 
	IIterator getIterator(); 
}
