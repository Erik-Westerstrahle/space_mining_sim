package space_mining_sim;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
public class AudioAndMusic {
	

	
	//optionsSpaceMiningSim optionsSpaceMiningSimInstance = new optionsSpaceMiningSim();
    private optionsSpaceMiningSim options;  // Use the same options instance

    public AudioAndMusic(optionsSpaceMiningSim options) {
        this.options = options;
    }
	
	
	public void playMenuSelectionSound()
	{
		if (options.getSoundBoolean()) {
             
           	
		
        try {
            URL soundFileURL = getClass().getResource("/space_mining_sim/Menu Selection Click.wav");
            if (soundFileURL == null) {
                System.out.println("Sound file not found!");
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFileURL);
            AudioFormat baseFormat = audioInputStream.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream decodedAudioInputStream = AudioSystem.getAudioInputStream(decodedFormat, audioInputStream);

            Clip clip = AudioSystem.getClip();
            clip.open(decodedAudioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Line unavailable: " + e.getMessage());
        }
    }
	}
	
    public void playToneAudio() throws LineUnavailableException {
        if (options.getSoundBoolean() == true) {
            int hz = 440;
            int msecs = 50;
            double vol = 0.3;

            byte[] buf = new byte[1];
            AudioFormat af = new AudioFormat(44100f, 8, 1, true, false);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            for (int i = 0; i < msecs * 8; i++) {
                double angle = i / (44100f / hz) * 2.0 * Math.PI;
                buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
                sdl.write(buf, 0, 1);
            }
            sdl.drain();
            sdl.stop();
            sdl.close();
        }
    }

	
	

}
	       
