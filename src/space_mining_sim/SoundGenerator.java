package space_mining_sim;

import javax.sound.sampled.*;

public class SoundGenerator {


    public static void playTone(int hz, int msecs, double vol) throws LineUnavailableException {
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

    public static void main(String[] args) throws LineUnavailableException {
        playTone(440, 50, 0.3); // 440 Hz for 50 ms with 30% volume
    }
}
