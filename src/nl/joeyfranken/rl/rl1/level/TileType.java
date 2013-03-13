package nl.joeyfranken.rl.rl1.level;

public enum TileType {
	NONE(false),
	FLOOR(false),
	WALL(true);
	
	public boolean solid;
	
	TileType(boolean solid) {
		this.solid = solid;
	}
}
