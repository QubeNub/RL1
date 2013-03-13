package nl.joeyfranken.rl.rl1.graphics;

import nl.joeyfranken.rl.rl1.level.TileType;

public class TileGraphics {
	public static char getCharForTile(TileType tile) {
		switch (tile) {
		case FLOOR:
			return '.';
		case WALL:
			return '#';
		default:
			return ' ';

		}
	}
}
