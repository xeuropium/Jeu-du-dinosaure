package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class Plateforme extends GameObject{

	public Plateforme(float x, float y, ID id) {
		super(x, y, id);
	}


	public void tick() {
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0, (int)(Game.HEIGHT / 1.5), Game.WIDTH, (int)(Game.HEIGHT / 1.5));	
	}

}
