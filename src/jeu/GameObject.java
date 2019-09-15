package jeu;

import java.awt.Graphics;


public abstract class GameObject {
	
	// Seulement les objets qui extends G_O ont acces a ces variables (accesseurs pour y acceder)
	protected float x, y; 
	protected ID id;
	protected float velX, velY;
	protected float gravity = 0.6f;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
	public ID getId() {
		return this.id;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return this.velX;
	}
	public float getVelY() {
		return this.velY;
	}
	public float getGravity() {
		return this.gravity;
	}

	
}
