package com.mycompany.a3;

public interface ICollider {
	public boolean collidesWith(GameObject object); 
	public void handleCollision(GameObject object); 
}
