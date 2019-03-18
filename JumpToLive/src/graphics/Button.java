package graphics;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Button {
	Main main;
	private int x, y;
	private int width, height;
	
	public Button(Main main, int x, int y, int width, int height) {
		this.main = main;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
	}
}
