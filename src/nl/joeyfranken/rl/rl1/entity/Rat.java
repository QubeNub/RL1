package nl.joeyfranken.rl.rl1.entity;

import nl.joeyfranken.rl.rl1.level.Level;

public class Rat extends Entity {

	private int damage;
	
	public Rat(Level level, int x, int y) {
		super(level, x, y);
		setHealth(10);
		damage = 1;
	}
	
	public void attack(Entity entity) {
		entity.doDamage(damage);
	}
}
