package nl.joeyfranken.rl.RL1.Grid;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import nl.joeyfranken.rl.RL1.graphics.Graphics;

public class Character {
	private char character;
	private BufferedImage image;
	
	public Character(char character) {
		this.character = character;
		setImage();
	}
	
	public Character(BufferedImage image) {
		this.image = image;
	}
	
	private void setImage() {
		Font font = new Font("Arial", Font.CENTER_BASELINE, (int) (Graphics.TILE_SIZE * 0.7));
		BufferedImage img = new BufferedImage(Graphics.TILE_SIZE, Graphics.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		g.setFont(font);
		g.drawString(String.valueOf(character), 0, Graphics.TILE_SIZE - 5);
		image = img;
		g.dispose();
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public char getChar() {
		return character;
	}
}
