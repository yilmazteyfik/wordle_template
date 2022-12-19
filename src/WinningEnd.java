import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;

public class WinningEnd extends JFrame implements MouseListener{
	JLabel msg = new JLabel();
	JFrame game = new JFrame();
	static JTextField save;
	Font msgFont = new Font("serif", Font.PLAIN, 52);
	Font btnFont = new Font("serif", Font.PLAIN, 20);
	JPanel buttons = new JPanel();
	JButton jbSave = new JButton("Save Score");
	JButton newGame = new JButton("New Game");
	JButton exit = new JButton("Exit");
	
	public WinningEnd(JFrame gm) {
		game = gm;
		gm.getContentPane().invalidate();
		gm.getContentPane().removeAll();
		gm.getContentPane().revalidate();
		gm.setSize(1000, 800);
		gm.setLocationRelativeTo(null);
		gm.setResizable(false);
		gm.add(new WinPanel(), BorderLayout.CENTER);
		gm.repaint();
		HandleEnd e = new HandleEnd(this, game, playWin());
		save = new JTextField("Enter your nickname");
		save.setFont(new Font("serif", Font.PLAIN, 24));
		save.setFocusable(false);
		msg.setText("    You Win!");
		msg.setFont(msgFont);
		this.add(msg, BorderLayout.NORTH);
		jbSave.addActionListener(e);
		newGame.addActionListener(e);
		exit.addActionListener(e);
		jbSave.setFont(btnFont);
		newGame.setFont(btnFont);
		exit.setFont(btnFont);
		buttons.add(jbSave);
		buttons.add(newGame);
		buttons.add(exit);
		this.add(save);
		this.add(buttons, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		save.addMouseListener(this);
		
	}
	
	Clip playWin() {
		Clip clip = null;
	      try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource("cyfmh.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	      return clip;
	   }


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == save) {
			save.setFocusable(true);
			save.grabFocus();
			if(save.getText().equals("Enter your nickname")) {
				save.setText("");
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
