package jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	
	public static Image getImage(String path) {
		Image image = null;
		try {
			// image = ImageIO.read(new File(path));
			image = ImageIO.read(ResourceLoader.load(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	

}
