package nl.joeyfranken.rl.rl1.grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import nl.joeyfranken.rl.rl1.graphics.Graphics;

public class Cell {
	private int x, y;
	private ArrayList<Character> chars;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		chars = new ArrayList<Character>();
	}

	public void draw(Graphics2D g) {
		if (chars.size() == 0)
			return;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Lucida Console", Font.BOLD, 14));

		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		if (Grid.ANTIALIASING) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		} else {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
		}

		int x = (this.x * Graphics.TILE_SIZE + 10) - g.getFontMetrics().charWidth(chars.get(chars.size() - 1)) / 2;
		int y = g.getFontMetrics().getMaxAscent() + (this.y * Graphics.TILE_SIZE + 10);
		g.drawString(String.valueOf(chars.get(chars.size() - 1)), x, y);

	}

	public void tick() {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void addChar(char c) {
		chars.add(new Character(c));
	}

	public void removeCharacter(char character) {
		for (int i = 0; i < chars.size(); i++) {
			if (chars.get(i) == character) {
				chars.remove(i);
				return;
			}
		}
	}
	
	public void popCharacter() {
		if(chars.size() > 0) {
			chars.remove(chars.size() -1);
		}
	}
	
	public void clear() {
		chars.clear();
	}
}
