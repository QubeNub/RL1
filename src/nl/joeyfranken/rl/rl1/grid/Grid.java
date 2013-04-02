package nl.joeyfranken.rl.rl1.grid;

import java.awt.Graphics2D;

public class Grid {

	public static final boolean ANTIALIASING = true;
	
	private Cell[][] cells;
	private int x, y, width, height;
	
	public Grid(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		cells = new Cell[width][height];
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[j][i] = new Cell(j, i);
				cells[j][i].addCharacter('.');
			}
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setCell(Cell cell) {
		if(cell != null && cell.getX() < width && cell.getY() < height) {
			cells[cell.getX()][cell.getY()] = cell;
		}
	}
	
	public Cell getCell(int x, int y) {
		if(x < width && y < height) {
			return cells[x][y];
		}
		return null;
	}
	
	public void draw(Graphics2D g) {
		for (int y = 0; y < cells[0].length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[x][y].draw(g, this.x, this.y);
			}
		}
	}
	
	public void clear() {
		for (int y = 0; y < cells[0].length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[x][y].clear();
			}
		}
	}
}
