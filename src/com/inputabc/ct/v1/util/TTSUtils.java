package com.inputabc.ct.v1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.voicerss.tts.AudioCodec;
import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.Languages;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;

import javazoom.jl.player.Player;
/**
 * 
 * @author gaoweiyi
 * @version 1
 */
public class TTSUtils {
	private static Player player ;
	public static void speak(final String content, final String language) {
		if(player!=null) {
			player.close();
		}
		File file = new File("v.mp3");
		if(file.exists()) {
			file.delete();
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				VoiceProvider tts = new VoiceProvider("f1b71bdd7c0447c3901389053925e3a2");
				try {
					VoiceParameters params = new VoiceParameters(content, language);
					params.setCodec(AudioCodec.MP3);
					params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
					params.setBase64(false);
					params.setSSML(false);
					params.setRate(0);
					byte[] voice = tts.speech(params);
					File file = new File("v.mp3");
					FileOutputStream fos = new FileOutputStream(file);
					fos.write(voice, 0, voice.length);
					fos.flush();
					fos.close();
					player = new Player(new FileInputStream(file));
					player.play();
					player.close();
					player=null;
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
