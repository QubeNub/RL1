package nl.joeyfranken.rl.RL1.Level;

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
	
	private TileType tiles[][];
	private int width, height;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new TileType[width][height];
		intArrayToLevel(defaultMap);
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setTile(int x, int y, TileType type) {
		if(x < width && y < height) {
			tiles[x][y] = type;
		}
	}

	public void setTile(int x, int y, int tile) {
		switch(tile) {
		case 0:
			setTile(x, y, TileType.NONE);
			break;
		case 1:
			setTile(x, y, TileType.FLOOR);
			break;
		case 2:
			setTile(x, y, TileType.WALL);
			break;
		}
	}
	
	public void intArrayToLevel(int[][] array) {
		if(array.length < 1 || array[0].length < 1) return;
		if(array.length != width || array[0].length != height) {
			width = array.length;
			height = array[0].length;
			tiles = new TileType[width][height];
		}
		width = array.length;
		height = array[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				setTile(x, y, array[y][x]);
			}
		}
	}

	public TileType getTile(int x, int y) {
		if(x < width && y < height) {
			return tiles[x][y];
		}
		return null;
	}
}
