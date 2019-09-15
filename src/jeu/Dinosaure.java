package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Dinosaure extends GameObject{

	Handler handler;
	
	
	
	Image dinosaureImageNormal = ImageLoader.getImage("dino1.png");
	Image dinosaureImageSaut = ImageLoader.getImage("dino5.png");
	Image dinosaureImageTombe = ImageLoader.getImage("dino4.png");
	
	String urlSonMort = "res/mortDinosaure.mp3";
	
	public Dinosaure(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = 0;
	}

	public void tick() {
		x += velX;
		velY += gravity;
		y += velY;
		
		if (y > Game.HEIGHT / 1.5 ) {
			velY= 0;
			y = (float) (Game.HEIGHT / 1.5);
		}
		
		collision();
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y -40 , 40, 40);
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Cactus) {
				Cactus cactus = (Cactus) tempObject;
				
				if(getBounds().intersects(cactus.getBounds())) {
					
					mort();
					break;
				}
			}
		}
	}
	
	public void mort() {
		System.out.println("hit");
		Sounds.jouerSon("res/mortDinosaure.wav");
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			System.exit(1);
		}
	}

	public void render(Graphics g) {
		// g.setColor(Color.black);
		// g.fillRect((int)x, (int)y -25, 25, 25);
		
		if(y < Game.HEIGHT /1.5) {
			g.drawImage(dinosaureImageSaut, (int)x, (int)y -40, null);
		} else {
			g.drawImage(dinosaureImageNormal, (int)x, (int)y -40, null);
		}
	}

}
