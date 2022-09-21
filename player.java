import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Code {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("rules_of_nature.wav");
		Scanner scanner = new Scanner(System.in);
		AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audiostream);
		
		String response = " ";
		
		while(!response.equals("Q")) {
			System.out.println("P = play / S = stop / R = reset / Q = quit");
			System.out.print("Enter your choice - ");
			
			response = scanner.next();
			response = response.toUpperCase();
			
			switch(response) {
				case("P"):
					clip.start();
					break;
				case("S"):
					clip.stop();
					break;
				case("R"):
					clip.setMicrosecondPosition(0);
					break;
				default: System.out.println("Not a valid response!");	
			}
		}
	}
}
