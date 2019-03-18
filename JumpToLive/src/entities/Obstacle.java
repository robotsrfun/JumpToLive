package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Obstacle {
	Main main;
	private int x, y1, y2;

	public Obstacle(Main main, int x, int top) {
		this.main = main;
		this.x = x + 1000;
		this.y1 += top;
		this.y2 = y1 + 175;
		this.y1 -= 400;
	}

	public void render(Graphics g) {
		if (this.x + 200 > 0 && this.x + 200 < 1200) {
			g.setColor(Color.green);
			g.fillRect(x, y1, 75, 400);
			g.fillRect(x, y2, 75, 400);
		}
	}

	public void pointsHandler() {
		if (this.main.player.getX() > this.x + 45 && this.main.player.getX() < this.x + 50) {
			this.main.addPoint();
		}
	}

	public void scroll() {
		this.x -= 4;
	}

	public boolean checkIfHit() {
		if (this.x + 200 > 0 && this.x + 200 < 1200) {
			if (this.main.player.getX() > this.x && this.main.player.getX() < this.x + 75) {
				if (this.main.player.getY() + 50 > y2) {
					return true;
				}
				if (this.main.player.getY() < y1 + 400) {
					return true;
				} else
					return false;
			} else
				return false;
		}
		return false;
	}
}
