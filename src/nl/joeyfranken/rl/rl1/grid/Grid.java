package nl.joeyfranken.rl.rl1.grid;

import java.awt.Graphics2D;

public class Grid {

	public static final boolean ANTIALIASING = true;
	private Cell[][] cells;
	private int width, height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		cells = new Cell[width][height];
		for (int y = 0; y < cells[0].length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[x][y] = new Cell(x, y);
				cells[x][y].addChar('#');
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setTile(Cell cell) {
		if(cell != null && cell.getX() < width && cell.getY() < height) {
			cells[cell.getX()][cell.getY()] = cell;
		}
	}
	
	public Cell getTile(int x, int y) {
		if(x < width && y < height) {
			return cells[x][y];
		}
		return null;
	}
	
	public void draw(Graphics2D g) {
		for (int y = 0; y < cells[0].length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[x][y].draw(g);
			}
		}
	}
	
	public void tick() {
		for (int y = 0; y < cells[0].length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[x][y].tick();
			}
		}		
	}
}
