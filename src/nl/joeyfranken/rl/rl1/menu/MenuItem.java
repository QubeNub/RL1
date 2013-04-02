package nl.joeyfranken.rl.rl1.menu;

public class MenuItem {
	private int index;
	private String text;
	
	public MenuItem(int index, String text) {
		this.index = index;
		this.text = text;
	}
	
	public String getText(int from, int to) {
		return text.substring(from, to);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
