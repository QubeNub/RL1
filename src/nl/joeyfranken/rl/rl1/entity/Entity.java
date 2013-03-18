package nl.joeyfranken.rl.rl1.entity;

import nl.joeyfranken.rl.rl1.level.Level;

public class Entity {

	private int x, y, health = 0;
	private Level level;
	private boolean alive;
	
	public Entity(Level level, int x, int y) {
		this.level = level;
		this.x = x;
		this.y = y;
		alive = true;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void die() {
		alive = false;
	}

	public void doDamage(int amount) {
		health -= amount;
		if(health <= 0) {
			health = 0;
			die();
		}
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
