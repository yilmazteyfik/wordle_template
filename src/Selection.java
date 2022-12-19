import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Selection {
	Selection(){
		JFrame jfSelection = new JFrame("WORDLE");
		JPanel jpQuestion = new JPanel();
		JPanel jpOptions = new JPanel();
		JLabel jlQuestion = new JLabel("Choose playing style");
		JButton b1 = new JButton("Keyboard");
		JButton b2 = new JButton("Drag and Drop");
		FlowLayout flQuestion = new FlowLayout();
		FlowLayout flOptions = new FlowLayout();
		jpQuestion.setLayout(flQuestion);
		jpOptions.setLayout(flOptions);
		Font fQuestion = new Font("serif", Font.PLAIN, 24);
		Font fButton = new Font("serif", Font.PLAIN, 20);
		b1.setFont(fButton);
		b2.setFont(fButton);
		jlQuestion.setFont(fQuestion);
		jpQuestion.add(jlQuestion);
		ButtonGroup bgOptions = new ButtonGroup();
		bgOptions.add(b1);
		bgOptions.add(b2);
		bgOptions.clearSelection();
		jpOptions.add(b1);
		jpOptions.add(b2);
		HandleSelection e1 = new HandleSelection(jfSelection);
		b1.addActionListener(e1);
		b2.addActionListener(e1);
		jfSelection.add(jpQuestion, BorderLayout.NORTH);
		jfSelection.add(jpOptions);
		jfSelection.setSize(300, 130);
		jfSelection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfSelection.setLocationRelativeTo(null);
		jfSelection.setResizable(false);
		jfSelection.setVisible(true);
	}
	
}
