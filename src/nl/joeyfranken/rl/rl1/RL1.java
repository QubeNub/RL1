package nl.joeyfranken.rl.RL1;

import nl.joeyfranken.rl.RL1.Grid.Grid;
import nl.joeyfranken.rl.RL1.Grid.Tile;
import nl.joeyfranken.rl.RL1.Level.Level;
import nl.joeyfranken.rl.RL1.graphics.Graphics;

public class RL1 {

	private Graphics graphics;
	private Thread graphicsThread;
	public Grid grid;
	public Level level;
	
	public RL1() {
		level = new Level(1, 1);
		grid = new Grid(20, 15);
		Tile tile = new Tile(1, 1);
		tile.addCharacter("@");
		grid.setTile(tile);
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
