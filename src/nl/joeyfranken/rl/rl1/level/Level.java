package nl.joeyfranken.rl.rl1.level;

import nl.joeyfranken.rl.rl1.entity.Entity;
import nl.joeyfranken.rl.rl1.entity.Player;

public class Level {

	private int defaultMap[][] = {	{2,2,2,2,2,2,2,2,2,2,2,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,1,2,1,1,1,1,1,1,2,1,2},
	   	                   			{2,1,1,1,1,1,1,1,1,1,1,2},
	   	                   			{2,2,2,2,2,2,2,2,2,2,2,2}
	   	                   		};
	
	private Tile tiles[][];
	private int width, height;

	private Player player;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		intArrayToLevel(defaultMap);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setTile(int x, int y, Tile type) {
		if(x < width && y < height) {
			tiles[x][y] = type;
		}
	}

	public void setTile(int x, int y, int tile) {
		switch(tile) {
		case 0:
			setTile(x, y, new Tile(TileType.NONE, x, y));
			break;
		case 1:
			setTile(x, y, new Tile(TileType.FLOOR, x, y));
			break;
		case 2:
			setTile(x, y, new Tile(TileType.WALL, x, y));
			break;
		}
	}
	
	public void intArrayToLevel(int[][] array) {
		if(array.length < 1 || array[0].length < 1) return;
		if(array.length != width || array[0].length != height) {
			width = array.length;
			height = array[0].length;
			tiles = new Tile[width][height];
		}
		width = array.length;
		height = array[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				setTile(x, y, array[y][x]);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if(x < width && y < height) {
			return tiles[x][y];
		}
		return null;
	}

	public Player getPlayer() {
		return player;
	}

	public boolean isValidMove(Entity entity, int x, int y) {
		if(x < width && y < height && x >= 0 && y >= 0 && tiles[x][y].isSolid()) {
			return false;
		}
		return true;
	}
}
