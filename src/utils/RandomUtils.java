package utils;

import java.awt.Color;
import java.util.Random;

public class RandomUtils {
	public static Random rand = new Random();
	
	public static int range(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}
	
	public static Color randomColor() {
		int r, g , b;
		do {
			r = range(0, 255);
			g = range(0, 255);
			b = range(0, 255);
		} while(r+g+b > 500);
		return new Color(r, g, b);
	}

}
