package jeu;

import java.util.Random;


public class Spawn {

	private Handler handler;
	private Random r = new Random();
	private final int positionDeSpawn = Game.WIDTH + r.nextInt(400);
	private final int espacementCactus = 30;
	
	
	private int compteur = 0;
	
	public Spawn(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		compteur ++;
		
		// A partir du dehors de l'ecran genere un nombre entre 0 et 400 de distance
		if(compteur == 100) {
			handler.addObject(new Cactus(positionDeSpawn, (float)((Game.HEIGHT / 1.5) - 55), 25, 55, ID.Cactus, handler));
			handler.addObject(new Cactus(positionDeSpawn + espacementCactus, (float)((Game.HEIGHT / 1.5) - 55), 25, 55, ID.Cactus, handler));	
		}
		
		
		if(compteur % 250 == 0) {
			
			handler.cactusSpeed += 0.5;
			
			int nbDeCactus = 2 + r.nextInt(4);
			for(int i = 1; i < nbDeCactus; i++) {
				handler.addObject(new Cactus((positionDeSpawn + (i * espacementCactus) ), (float)((Game.HEIGHT / 1.5) - 55), 25, 55, ID.Cactus, handler));
			}
		}
		
		
		
	}
	
}
