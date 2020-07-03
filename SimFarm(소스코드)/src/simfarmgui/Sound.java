package simfarmgui;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	public static Clip clip;
	public Sound(String file, boolean Loop){
		try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
		clip = AudioSystem.getClip();
		clip.open(ais);
		clip.start();
		if ( Loop) 
			clip.loop(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
