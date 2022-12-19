import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Help extends JPanel{
	Font msgFont = new Font("serif", Font.PLAIN, 18);
	Font txtFont = new Font("serif", Font.PLAIN, 32);
	public Help() {
		this.setLayout(new GridLayout(6, 1));
		this.setBackground(new Color(204, 204, 255));
		JLabel title = new JLabel("      How to Play");
		title.setFont(txtFont);
		JPanel jpBlack = new JPanel();
		jpBlack.setBackground(new Color(204, 204, 255));
		JTextField black = new JTextField("T   ");
		black.setBackground(Color.LIGHT_GRAY);
		black.setFont(txtFont);
		black.setFocusable(false);
		black.setEditable(false);
		JLabel msg1 = new JLabel("means it's not in the word.");
		msg1.setFont(msgFont);
		JPanel jpYellow = new JPanel();
		jpYellow.setBackground(new Color(204, 204, 255));
		JTextField yellow = new JTextField("T   ");
		yellow.setBackground(Color.YELLOW);
		yellow.setFont(txtFont);
		yellow.setFocusable(false);
		yellow.setEditable(false);
		JLabel msg2 = new JLabel(" in the word but wrong spot.");
		msg2.setFont(msgFont);
		JPanel jpGreen = new JPanel();
		jpGreen.setBackground(new Color(204, 204, 255));
		JTextField green = new JTextField("T   ");
		green.setBackground(Color.GREEN);
		green.setFont(txtFont);
		green.setFocusable(false);
		green.setEditable(false);
		JLabel msg3 = new JLabel(" in the word and correct spot.");
		msg3.setFont(msgFont);
		JLabel msg4 = new JLabel("Press enter to check, backspace to del.");
		msg4.setFont(msgFont);
		msg4.setBackground(new Color(204, 204, 255));
		JLabel msg5 = new JLabel("You should find in 5 tries, good luck!");
		msg5.setFont(msgFont);
		msg5.setBackground(new Color(204, 204, 255));
		jpBlack.add(black);
		jpBlack.add(msg1);
		jpYellow.add(yellow);
		jpYellow.add(msg2);
		jpGreen.add(green);
		jpGreen.add(msg3);
		this.add(title);
		this.add(jpBlack);
		this.add(jpYellow);
		this.add(jpGreen);
		this.add(msg4);
		this.add(msg5);
	}
}

