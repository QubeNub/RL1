package nl.joeyfranken.rl.RL1.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class TileSet {

	private InputStream tileSetImageStream;
	private BufferedImage image;
	private BufferedImage[][] tiles;
	private int tileWidth, tileHeight;
	
	public TileSet(InputStream inputStream, int tileWidth, int tileHeight) {
		this.tileSetImageStream = inputStream;
		this.tileHeight = tileHeight;
		this.tileWidth = tileWidth;
		tiles = new BufferedImage[tileWidth][tileHeight];
		readFile();
		readFileToSet();
	}
	
	public BufferedImage getTileImage(int x, int y) {
		if(x < tiles.length && y < tiles[x].length) {
			return tiles[x][y];
		}
		return null;
	}
	
	private void readFile() {
		try {
			image = ImageIO.read(tileSetImageStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readFileToSet() {
		for (int x = 0; x < image.getHeight() / tileHeight; x++) {
			for (int y = 0; y < image.getWidth() / tileWidth; y++) {
				tiles[x][y] = image.getSubimage(y * tileHeight, x * tileWidth, tileWidth, tileHeight);
			}
		}
	}
}
