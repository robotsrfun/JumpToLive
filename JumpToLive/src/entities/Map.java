package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import main.Main;

public class Map {
	Main main;
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	
	public Map(Main main) {
		this.main = main;
	}
	
	public void tick() {
		for(int i = 0; i < this.obstacles.size(); i++) {
			
			this.obstacles.get(i).pointsHandler();
			
			if(this.obstacles.get(i).checkIfHit()) {
				this.main.endGame();
			}
		}
		
		
	}

	public void genObstacle() {
		this.obstacles.add(new Obstacle(this.main, this.main.player.getX(), generateOpening()));
	}
	
	public int generateOpening() {	
		int x = (int)(Math.random()*5)*100;
		
		return x;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < obstacles.size(); i++ ) {
			obstacles.get(i).render(g);
		}
		
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		g.drawString(this.main.getPoints(), 450, 125);
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		g.drawString(this.main.getHighscore(), 10, 30);
	}
	
	public void scroll() {
		for(int i = 0; i < this.obstacles.size(); i ++) {
			obstacles.get(i).scroll();
		}
	}

	public void clearObstacles() {
		this.obstacles.clear();
	}
	
}
