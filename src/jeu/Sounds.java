package jeu;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Sounds {
	
	
	
	public static void jouerSon(String url) {
		try {
			AudioClip son = Applet.newAudioClip(new URL("file","",url)); // "res/mortDinosaure.mp3"
			son.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("mauvaise url");
		}
	}

}
