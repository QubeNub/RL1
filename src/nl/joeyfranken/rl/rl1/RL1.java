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
		Player player = new Player(level, 4, 4);
		level.setPlayer(player);
		grid = new Grid(20, 15);
		graphics = new Graphics(this);
		graphics.setGrid(grid);
		graphicsThread = new Thread(graphics);
		graphicsThread.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RL1();
	}

}
