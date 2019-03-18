package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Main;

public class GameOver {
	Main main;
	
	public GameOver(Main main) {
		this.main = main;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 600);
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		g.drawString("Game Over", 250, 200);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		g.drawString("Press R To Restart", 275, 400);
	}
}
