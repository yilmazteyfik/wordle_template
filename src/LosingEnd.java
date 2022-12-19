import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LosingEnd extends JFrame{
	JFrame game = new JFrame();
	JLabel msg = new JLabel();
	Font msgFont = new Font("serif", Font.PLAIN, 32);
	Font btnFont = new Font("serif", Font.PLAIN, 20);
	JPanel buttons = new JPanel();
	JButton newGame = new JButton("New Game");
	JButton exit = new JButton("Exit");
	String word;
	public LosingEnd(JFrame gm, String orjWord) {
		game = gm;
		gm.getContentPane().invalidate();
		gm.getContentPane().removeAll();
		gm.getContentPane().revalidate();
		
		gm.add(new EndPanel());
		gm.repaint();
		HandleEnd e = new HandleEnd(this, game, playStan());
		word = orjWord;
		msg = new JLabel("You Lose! It was " + word, SwingConstants.CENTER);
		msg.setFont(msgFont);
		this.add(msg);
		newGame.setFont(btnFont);
		exit.setFont(btnFont);
		newGame.addActionListener(e);
		exit.addActionListener(e);
		buttons.add(newGame);
		buttons.add(exit);
		this.add(buttons, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	   Clip playStan() {
		   	Clip clip = null;
		      try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("stan.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.start();
		      } catch (UnsupportedAudioFileException e) {
		         
		      } catch (IOException e) {
		         
		      } catch (LineUnavailableException e) {
		         
		      }
		      return clip;
		   }
	
}
