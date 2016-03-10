package week5;

import java.util.Random;

public class Tile {
	public enum IconType {
		SUN, LEAVES, CLOUD, FLOWER, TIGER, DRAGON, BIRD, COMPUTER
	}
	private IconType picOne;
	private IconType picTwo;

	public Tile() {
		Random random = new Random();
		this.picOne = IconType.values()[random.nextInt(IconType.values().length)];
		this.picTwo = IconType.values()[random.nextInt(IconType.values().length)];
	}

	public IconType getPicOne() {
		return picOne;
	}

	public IconType getPicTwo() {
		return picTwo;
	}

	@Override
	public String toString() {
		return this.picOne + "/" + this.picTwo;
	}
}