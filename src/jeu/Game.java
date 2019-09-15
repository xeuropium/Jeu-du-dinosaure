package jeu;

/**
 * Fait par Felix Pousse
 * Main classe qui contient la boucle de fps, les objets, la fenetre
 * On compile le code ici
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 1000, HEIGHT = 600;	//700 par 200
	
	
	private Thread thread;
	private boolean running = false;
	private Spawn spawn;
	private NuagesAnimation nuages;
	
	private Handler handler;
	
	
	public Game() {
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Le jeu du Dinosaure", this);
		
		spawn = new Spawn(handler);
		
		//On ajoute les objets ici
		handler.addObject(new Plateforme(0, 0, ID.Sol));
		handler.addObject(new Dinosaure(100, (float)(HEIGHT / 2), ID.Dinosaure, handler));	
		
		nuages = new NuagesAnimation(handler);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running= true;
		
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void run() {
	  	long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println(frames);
                frames = 0;
            }
        }
        stop();
	}

	private void tick() {
		handler.tick();
		spawn.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else
			if(var <= min)
				return var = min;
			else
				return var;
	}
	
	
	public static void main(String[] args) {
		new Game();
	}
}
