package nl.joeyfranken.rl.RL1.graphics;

import java.awt.image.BufferedImage;

import nl.joeyfranken.rl.RL1.Level.TileType;

public class TileGraphics {
	public static BufferedImage getImageForTile(TileType tile, TileSet tileSet) {
		switch(tile) {
		case NONE:
			return new BufferedImage(Graphics.TILE_SIZE, Graphics.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
		case FLOOR:
			return tileSet.getTileImage(3, 7);
		case WALL:
			return tileSet.getTileImage(0, 3);
		}
		return null;
	}
}
