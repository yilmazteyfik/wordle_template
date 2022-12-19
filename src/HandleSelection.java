import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class HandleSelection implements ActionListener{
	JFrame frame;
	
	public HandleSelection(JFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		if (e.getActionCommand() == "Keyboard") {
			KeyboardGame kGame = new KeyboardGame();
			kGame.HandleGame();
		}
		else if (e.getActionCommand() == "Drag and Drop") {
			DragDropGame ddGame = new DragDropGame();
			ddGame.initializeGame();
		}
	}	
}
