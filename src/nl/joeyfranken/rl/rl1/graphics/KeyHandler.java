package nl.joeyfranken.rl.rl1.graphics;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nl.joeyfranken.rl.rl1.RL1;

public class KeyHandler implements KeyListener {
	private RL1 instance;
	
	public KeyHandler(RL1 instance) {
		this.instance = instance;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			instance.level.getPlayer().move(0, -1);
			break;
		case KeyEvent.VK_RIGHT:
			instance.level.getPlayer().move(1, 0);
			break;
		case KeyEvent.VK_DOWN:
			instance.level.getPlayer().move(0, 1);
			break;
		case KeyEvent.VK_LEFT:
			instance.level.getPlayer().move(-1, 0);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
