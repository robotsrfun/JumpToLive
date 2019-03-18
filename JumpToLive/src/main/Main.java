package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import entities.Map;
import entities.Player;
import graphics.GameOver;
import graphics.GraphicsHandler;
import utility.GameState;
import utility.Keyboard;
import utility.Timers;

public class Main extends Canvas implements Runnable {

	public Keyboard key;
	public GraphicsHandler gHandler;
	public Timers timers;
	public Player player;
	public Map map;
	public GameOver gameOver;
	
	public GameState gameState = GameState.game;
	
	private int totalPoints;
	private int highscore;
	
	public String getPoints() {
		return totalPoints + "";
	}
	
	public String getHighscore() {
		return "Highscore: " + highscore;
	}
	
	public void addPoint() {
		this.totalPoints++;
	}
	
	public Main() {
		key = new Keyboard(this);
		gHandler = new GraphicsHandler(this);
		timers = new Timers(this);
		player = new Player(this, 100, 200, 50, 50);
		map = new Map(this);
		gameOver = new GameOver(this);
		
		JFrame jf = new JFrame();
		this.addKeyListener(key);
		jf.setSize(new Dimension(1000, 600));
		jf.setVisible(true);
		jf.setTitle("JumpToLive");
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		start();
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void restart() {
		if(this.totalPoints > highscore) {
			this.highscore = totalPoints;
		}
			
		this.totalPoints = 0;
		this.map.clearObstacles();
		this.player.reset();
		this.gameState = GameState.game;
	}
	
	private boolean running = true;

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			timers.allTimers();
		}
		stop();
	}

	public void tick() {
		if(gameState == GameState.game) {
			player.tick();
			key.tick();
			map.tick();
		}
	}
	
	public void endGame() {
		this.gameState = GameState.gameOver;
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		
		gHandler.render(g);
		
		g.dispose();
		bs.show();
	}

	private Thread thread;

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}