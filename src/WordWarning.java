import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WordWarning extends JFrame implements MouseListener{
	JLabel msg = new JLabel();
	Font msgFont = new Font("serif", Font.PLAIN, 48);
	public WordWarning(String orjWord) {
		super(orjWord);
		msg.setText("This is not a valid word.");
		msg.setFont(msgFont);
		this.add(msg);
		addMouseListener(this);
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		this.dispose();
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.dispose();
	}
}
