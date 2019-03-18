package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Player {
	Main main;
	private int x, y;
	private int width, height;
	private boolean jumping = false;
	private boolean playerMoving = true;

	public Player(Main main, int x, int y, int width, int height) {
		this.main = main;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void tick() {
		if (playerMoving)
			sideScrolling();
		mapHandler();

		if (!jumping) {
			gravity();
			checkBoundaries();
		}
	}
	
	public void reset() {
		this.x = 100;
		this.y = 200;
		playerMoving = true;
	}
	
	public void mapHandler() {
		if (x > 400) {
			playerMoving = false;
			this.main.map.scroll();
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void jump() {
		for (int i = 0; i < 4; i++) {
			y -= 5;
		}
		jumping = false;
	}

	private int gravity = 6;

	public void gravity() {
		y += gravity;
	}

	public void sideScrolling() {
		x += 2;
	}

	public void checkBoundaries() {
		if (y < 20)
			y = 20;
		if (y + height > 570)
			y = 520;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	
	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
