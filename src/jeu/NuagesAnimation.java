package jeu;

import java.util.ArrayList;

public class NuagesAnimation {
	
	private ArrayList<Nuage> nuages;
	private Handler handler;
	
	
	public NuagesAnimation(Handler handler) {
		this.handler = handler;
		
		nuages = new ArrayList<>();
		
		nuages.add(new Nuage(200, 80, ID.Nuage, handler));
		nuages.add(new Nuage(500, 100, ID.Nuage, handler));
		nuages.add(new Nuage(700, 140, ID.Nuage, handler));
		nuages.add(new Nuage(900, 120, ID.Nuage, handler));
		nuages.add(new Nuage(1000, 60, ID.Nuage, handler));
		
		ajoutNuages();
	}
	
	
	public void ajoutNuages() {
		for(Nuage nuage : nuages) {
			handler.addObject(nuage);
		}
	}
	
	

}
