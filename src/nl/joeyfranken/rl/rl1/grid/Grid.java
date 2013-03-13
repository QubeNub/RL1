package nl.joeyfranken.rl.RL1.Grid;

import java.awt.Graphics2D;

public class Grid {

	private Tile[][] tiles;
	private int width, height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				tiles[x][y] = new Tile(x, y);
				tiles[x][y].addCharacter("·");
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setTile(Tile tile) {
		if(tile != null && tile.getX() < width && tile.getY() < height) {
			tiles[tile.getX()][tile.getY()] = tile;
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < width && y < height) {
			return tiles[x][y];
		}
		return null;
	}
	
	public void draw(Graphics2D g) {
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				tiles[x][y].draw(g);
			}
		}
	}
	
	public void tick() {
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				tiles[x][y].tick();
			}
		}		
	}
}
