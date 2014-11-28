/** Copyright (C) 2013 Alexander Mariel

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/**
 * Autor: Alexander Mariel
 * Modified by: Asier Mujika
 * Trabajo para la asignatura TAIA
 * Practica individual con agentes en la plataforma JADE 
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class plays/stops/pauses an audio clip loaded from the file system
 * 
 * @author Alex
 *
 */
public class AudioPlayer
{	
	private Clip sound;
	private AudioInputStream ais;
	
	/**
	 * Constructor, loads the audio clip with the given name
	 * @param pFileName audio clip name
	 */
	public AudioPlayer(String pFileName)
	{
	    try
		{	    	
	    	//Open file
	    	File f = new File(pFileName);
	    	//Read data
		    sound = AudioSystem.getClip();
		    ais = AudioSystem.getAudioInputStream(f);
		    //Get file format
		    AudioFormat format = ais.getFormat();
		    DataLine.Info info = new DataLine.Info(Clip.class, format);

	        sound = (Clip)AudioSystem.getLine(info);
		    sound.open(ais);
		}
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Plays a sound from the beginning
	 */
	public void startSound()
	{
		sound.setFramePosition(0);
		playSound();
		sound.loop(10);
	}
	
	/**
	 * Plays a sound from the point where it was stopped
	 */
	public void playSound()
	{
		sound.start();
	}
	
	/**
	 * Stops a sound
	 */
	public void pauseSound()
	{
		sound.stop();
	}
}