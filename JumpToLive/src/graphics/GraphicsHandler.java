package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Main;
import utility.GameState;

public class GraphicsHandler {
	Main main;
	
	public GraphicsHandler(Main main) {
		this.main = main;
	}
	
	public void render(Graphics g) {
		if(this.main.gameState == GameState.game) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 600);
		
			this.main.map.render(g);
			this.main.player.render(g);
			
			if(this.main.player.getX() < 400) {
				g.setColor(Color.red);
				g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
				g.drawString("Press SPACE To Jump", 250, 300);
			}
		}
		else
			this.main.gameOver.render(g);
	}
}
