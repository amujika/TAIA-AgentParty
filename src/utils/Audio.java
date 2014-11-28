package utils;

import java.util.TreeMap;

public class Audio {
	static TreeMap<String, AudioPlayer> sounds = new TreeMap<String, AudioPlayer>();
	
	public static void addSound(String file) {
		AudioPlayer sound = new AudioPlayer(file);
		sound.startSound();
		sounds.put(file, sound);
	}
	
	public static void removeSound(String file) {
		sounds.get(file).pauseSound();
		sounds.remove(file);
	}
}
