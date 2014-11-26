package utils;

import java.util.Random;

public class RandomUtils {
	public static Random rand = new Random();
	
	public static int range(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}

}
