package jeu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private boolean space = false;
	private Handler handler;
	
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		// Savoir quel objet bouger
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Dinosaure) {
				// key event for player 1
				
				if(key == KeyEvent.VK_SPACE && tempObject.getY() == Game.HEIGHT / 1.5) { 
					tempObject.setVelY(- 15); 
				}
				
			}
		}
		
		// Quitter le jeu
		if(key == KeyEvent.VK_ESCAPE) 
			System.exit(1);
		
		
			
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		// Savoir quel joueur bouger
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			//On peut faire des petits sauts mais on ne peut pas set velY à 0 dans la redescente 
			if(tempObject.getId() == ID.Dinosaure && tempObject.getVelY() < 0) {	
				// key event for player 1

				if(key == KeyEvent.VK_SPACE) tempObject.setVelY(0);
				
				
			}
		}
	}

}
