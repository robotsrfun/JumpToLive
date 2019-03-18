package utility;

import main.Main;

public class Timers {
	Main main;

	public Timers(Main main) {
		this.main = main;
	}

	public void allTimers() {
		timerObstacle();
	}

	// Template for time based events
	int time = 0;
	long a = System.currentTimeMillis();

	public void timerA() {
		if (System.currentTimeMillis() - a > 1000) {
			a = System.currentTimeMillis();
			time++;
			System.out.println(time);

			// Below place what you want timed

		}
	}

	int obstacleTime = 0;
	long obstacleA = System.currentTimeMillis();

	int obstacleTimerSpeed = 1500;

	public void timerObstacle() {
		if (this.main.player.getX() > 400) {
			if (System.currentTimeMillis() - obstacleA > obstacleTimerSpeed) {
				obstacleA = System.currentTimeMillis();
				obstacleTime++;
				this.main.map.genObstacle();
			}
		}
	}
	
}
