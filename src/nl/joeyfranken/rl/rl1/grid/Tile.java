package nl.joeyfranken.rl.RL1.Grid;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import nl.joeyfranken.rl.RL1.graphics.Graphics;

public class Tile {
	private int x, y;
	private ArrayList<Character> chars;
	private int imagePointer;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		chars = new ArrayList<Character>();
		imagePointer = -1;
	}
	
	public void draw(Graphics2D g) {
		if(chars.size() == 0) return;
		g.drawImage(chars.get(imagePointer).getImage(), x * Graphics.TILE_SIZE, y * Graphics.TILE_SIZE, Graphics.TILE_SIZE, Graphics.TILE_SIZE, null);
	}
	
	public void tick() {
		if(imagePointer == chars.size() - 1) {
			imagePointer = 0;
		} else {
			imagePointer++;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void addCharacter(String character) {
		if(character.length() != 1) return;
		chars.add(new Character(character.charAt(0)));
		if(imagePointer == -1) imagePointer++;
	}
	
	public void addImage(BufferedImage img) {
		if(img == null) return;
		chars.add(new Character(img));
		if(imagePointer == -1) imagePointer++;
	}
	
	public void removeCharacter(char character) {
		for(int i = 0; i < chars.size(); i++) {
			if(chars.get(i).getChar() == character) {
				chars.remove(i);
				return;
			}
		}
	}
}
