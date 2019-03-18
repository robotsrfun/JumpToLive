package utility;

import java.awt.event.*;

import main.Main;

public class Keyboard implements KeyListener {
	public Main main;
	boolean[] keys = new boolean[360];
	public boolean left, right, up, down, space;

	public Keyboard(Main main) {
		this.main = main;
	}

	public void tick() {
		// left = keys[KeyEvent.VK_A];
		
		space = keys[KeyEvent.VK_SPACE];
		
		
		if(space) {
			main.player.setJumping(true);
			main.player.jump();
		}
	}

	public void keyPressed(KeyEvent e) {
		this.keys[e.getKeyCode()] = true;
		
		if(e.getKeyCode() == KeyEvent.VK_R) {
			this.main.restart();
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		this.keys[e.getKeyCode()] = false;
	}
}