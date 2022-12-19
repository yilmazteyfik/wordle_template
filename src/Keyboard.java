import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public 
class Keyboard extends JPanel{
	static JButton letters[] = new JButton[26];
	Font lttrFont = new Font("serif", Font.PLAIN, 32);
	
	public Keyboard(){
		this.setLayout(new GridLayout(2, 13));
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new JButton(Character.toString('A' + i));
			letters[i].setEnabled(false);
			letters[i].setBackground(Color.cyan);
			letters[i].setFont(lttrFont);
			this.add(letters[i]);
		}
	}
	static void makeGreen(String ltr) {
		for (int i = 0; i < letters.length; i++) {
			if (letters[i].getText().equals(ltr))
				letters[i].setBackground(Color.GREEN);
		}
	}
	
	static void makeYellow(String ltr) {
		for (int i = 0; i < letters.length; i++) {
			if (letters[i].getText().equals(ltr) && letters[i].getBackground() != Color.GREEN)
				letters[i].setBackground(Color.YELLOW);
		}
	}
	
	static void makeGray(String ltr) {
		for (int i = 0; i < letters.length; i++) {
			if (letters[i].getText().equals(ltr) && letters[i].getBackground() != Color.GREEN
					&& letters[i].getBackground() != Color.YELLOW)
				letters[i].setBackground(Color.LIGHT_GRAY);
		}
	}
}
