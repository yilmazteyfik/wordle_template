import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class HandleEnd implements ActionListener{
	JFrame frame;
	JFrame game;
	String nick;
	Clip sound;
	boolean isSaved;
	
	public HandleEnd(JFrame frame, JFrame game, Clip sound) {
		super();
		this.frame = frame;
		this.game = game;
		if (sound != null)
			this.sound = sound;
		
		isSaved = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == "New Game") {
			if (sound != null)
				sound.close();
			frame.dispose();
			game.dispose();
			WordFile.initiliazeWord();
			Selection newGame = new Selection();
		}
		else if(e.getActionCommand() == "Save Score") {
			if(!isSaved && !WinningEnd.save.getText().equals("Enter your nickname")) {
				isSaved= true;
				if (KeyboardGame.scoreboard != null)
					KeyboardGame.scoreboard.addScores();
				else
					DragDropGame.scoreboard.addScores();
			}
			
		}
		else if (e.getActionCommand() == "Exit") {
			if (sound != null)
				sound.close();
			frame.dispose();
			game.dispose();
		}
	}	
}

