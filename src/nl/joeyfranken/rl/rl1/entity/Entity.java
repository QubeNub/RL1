package nl.joeyfranken.rl.rl1.entity;

import nl.joeyfranken.rl.rl1.level.Level;

public class Entity {

	private int x, y;
	private Level level;
	
	public Entity(Level level, int x, int y) {
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(int dx, int dy) {
		if(level.isValidMove(this, x + dx, y + dy)) {
			x += dx;
			y += dy;
		}
	}
}
