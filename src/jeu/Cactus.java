package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Cactus extends GameObject{

	private Handler handler;
	
	private int tailleX, tailleY;
	private Color color = Color.red;
	
	Image cactusImage = ImageLoader.getImage("cactus_dinosaure.png");
	
	
	public Cactus(float x, float y, int tailleX, int tailleY, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		
	}

	public void tick() {
		velX = handler.cactusSpeed;
		x -= velX;
		
		if(x < 0) {
			handler.removeObject(this);
		}
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 25, 55);
	}

	
	public void render(Graphics g) {
		// g.setColor(Color.BLACK);
		//g.fillRect((int)x, (int)y, tailleX, tailleY);	//25, 55
		
		//g.setColor(color);
		//g.fillRect((int)x+2, (int)y+2, tailleX-3, tailleY-3          );	//25, 55
		
		g.drawImage(cactusImage, (int)x, (int)y, null);
	}
	
	

}
