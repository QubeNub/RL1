package nl.joeyfranken.rl.rl1.menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Menu {

	private int x, y, width, height;
	private ArrayList<MenuItem> menuItems;
	
	public Menu(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		menuItems = new ArrayList<MenuItem>();
	}
	
	public void draw(Graphics2D g) {
		int rowCounter = 0;
		for(int i = 0; i < menuItems.size(); i++) {
			g.setColor(Color.WHITE);
			if(menuItems.get(i).getText().length() > width) {
				for(int j = 0; j < menuItems.get(i).getText().length() % width + 1; j++) {
					g.drawString(menuItems.get(i).getText(j * width, (j + 1) * width), x, y + (rowCounter * 20));
					rowCounter++;
				}
			} else {
				g.drawString(menuItems.get(i).getText(), x, y + (rowCounter * 20));
				rowCounter++;
			}
		}
	}
	
	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}
	
	public void removeMenuItem(MenuItem menuItem) {
		menuItems.remove(menuItem);
	}
	
	public void purgeMenuItems() {
		menuItems.clear();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
