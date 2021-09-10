import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Musica {
	
	private AudioClip musica;
	
	public Musica(){
		URL url = getClass().getResource("Audio/musica.wav");
		musica   = Applet.newAudioClip(url); 
		
	}
	public void play(){
		musica.loop();
	}
	public void stop(){
		musica.stop();
	}
	
}
