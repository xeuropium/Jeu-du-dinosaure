package jeu;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public float cactusSpeed = 5f;
	
	// Permet de d'executer les methodes tick et render de tous les objets
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public String toString() {
		String message = "";
		
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			message += "id = " + tempObject.getId() + " x :" + tempObject.getX() + " | ";
		}
		return message;
	}
}
