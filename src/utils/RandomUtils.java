package utils;

import java.awt.Color;
import java.util.Random;

public class RandomUtils {
	public static Random rand = new Random();
	
	public static int range(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}
	
	public static Color randomColor() {
		return new Color(range(0, 255), range(0, 255), range(0, 255));
	}

}
