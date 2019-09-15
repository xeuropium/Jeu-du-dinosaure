package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Nuage extends GameObject{

	private Random r = new Random();
	private Handler handler;
	private float vitesseNuage = 0.5f;
	private boolean respawn = true;
	
	private final int distanceMinimaleRespawn = 100;
	
	
	Image imageNuage = ImageLoader.getImage("nuage.png");
	
	
	public Nuage(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
	}

	@Override
	public void tick() {
		velX = vitesseNuage;
		x -= velX;
		
		if(peutRespawn()) {
			this.x = Game.WIDTH + r.nextInt(200) + distanceMinimaleRespawn;
		}
		
		if(x < 0) {
			handler.removeObject(this);
		}
		
	}
	
	private boolean peutRespawn() {
		if(x < 50 && respawn) {
			respawn = false;
			return true;
		} else {
			return false;
		}
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(imageNuage, (int)x, (int)y, null);	
	}

}
