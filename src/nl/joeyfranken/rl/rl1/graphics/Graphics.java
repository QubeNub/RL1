package nl.joeyfranken.rl.rl1.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.joeyfranken.rl.rl1.RL1;
import nl.joeyfranken.rl.rl1.grid.Grid;
import nl.joeyfranken.rl.rl1.input.KeyHandler;
import nl.joeyfranken.rl.rl1.level.Level;

public class Graphics extends Canvas implements Runnable {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static final String GAME_TITLE = "RL1";
	public final static int TILE_SIZE = 24;
	
	private static final long serialVersionUID = 896952198601396240L;
	private boolean running;
	private JFrame container;
	private JPanel panel;
	private BufferStrategy strategy;
	private RL1 instance;
	private Grid grid;
	
	public Font font;
	
	public Graphics(RL1 instance) {
		this.instance = instance;
		createWindow();
		font = new Font("Lucida Console", Font.PLAIN, 14);
		running = true;
	}

	public void tick() {
		grid.tick();
	}
	
	@Override
	public void run() {
		long lastLoopTime = System.nanoTime();
		long lastFpsTime = 0;
		int fps = 0;
		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			lastFpsTime += updateLength;
			fps++;
			
			draw();
			
			if (lastFpsTime >= 1000000000) {
				container.setTitle(GAME_TITLE + " - FPS: " + fps);
				lastFpsTime = 0;
				fps = 0;
				tick();
			}
			try {
				Thread.sleep((lastLoopTime - System.nanoTime()) / 1000000 + 17);
			} catch (Exception e) {

			}
		}
	}

	public void draw() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		BufferedImage img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D drawG = img.createGraphics();
		drawG.setColor(Color.black);
		drawG.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		// draw dat shiet wif drawG
		drawGrid(drawG);
		
		g.drawImage(img, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
		drawG.dispose();
		g.dispose();
		strategy.show();
	}
	
	private void drawGrid(Graphics2D drawG) {
		setGrid(instance.level);
		if(grid != null) grid.draw(drawG);
	}

	public void setGrid(Level level) {
		if(grid.getWidth() != level.getWidth() || grid.getHeight() != level.getHeight()) {
			grid = new Grid(level.getWidth(), level.getHeight());
		} else {
			grid.clear();
		}
		for (int y = 0; y < level.getHeight(); y++) {
			for (int x = 0; x < level.getWidth(); x++) {
				grid.getCell(x, y).addCharacter(TileGraphics.getCharForTile(level.getTile(x, y).getType()));
			}
		}
		grid.getCell(level.getPlayer().getX(), level.getPlayer().getY()).addCharacter('@');
	}

	private void createWindow() {
		container = new JFrame(GAME_TITLE);
		
		panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		panel.setLayout(null);
		
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		panel.add(this);
		
		addKeyListener(new KeyHandler(instance));
		
		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setIgnoreRepaint(true);
		
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		requestFocus();
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}

	public void setGrid(Grid grid) {
		if(grid != null) {
			this.grid = grid;
		}
	}
	
	public void setFont(Font font) {
		if(font != null) {
			this.font = font;
		}
	}
}
