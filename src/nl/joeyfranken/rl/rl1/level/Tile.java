package nl.joeyfranken.rl.rl1.level;

public class Tile {
	private TileType type;
	private int x, y;
	
	public Tile(TileType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public TileType getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public boolean isSolid() {
		return type.solid;
	}
}
