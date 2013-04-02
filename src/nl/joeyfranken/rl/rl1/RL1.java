package nl.joeyfranken.rl.rl1;

import nl.joeyfranken.rl.rl1.entity.Player;
import nl.joeyfranken.rl.rl1.graphics.Graphics;
import nl.joeyfranken.rl.rl1.grid.Grid;
import nl.joeyfranken.rl.rl1.level.Level;

public class RL1 {

	private Graphics graphics;
	private Thread graphicsThread;
	public Grid grid;
	public Level level;
	
	public RL1() {
		level = new Level(1, 1);
		level.setPlayer(new Player(level, 4, 3));
		grid = new Grid(0, 0, 12, 12);
		graphics = new Graphics(this);
		graphics.addGrid(grid, level);
		graphicsThread = new Thread(graphics);
		graphicsThread.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RL1();
	}

	public void endGame() {
		System.exit(0);
	}

}
