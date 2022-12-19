import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class KeyboardGame{
	static long score; 
	Border borderColor = BorderFactory.createLineBorder(Color.blue, 2);
	static HighScores scoreboard;
	static JFrame jfGame;
	Font letterFont = new Font("serif", Font.PLAIN, 32);
	JPanel jpTries = new JPanel();
	ClockText clock = new ClockText();
	static long start;
	
	public void HandleGame() {
		this.InitiliazeGame();
		
	}
	public void InitiliazeGame() {
		start = System.currentTimeMillis();
		jfGame = new JFrame("Keyboard");
		jpTries.setLayout(new GridLayout(5,1));
		clock.setLayout(new FlowLayout());
		jfGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreboard = new HighScores(true);
		tries();

		jfGame.add(clock, BorderLayout.NORTH);
		jfGame.add(new Keyboard(), BorderLayout.SOUTH);
		jfGame.add(scoreboard, BorderLayout.EAST);
		jfGame.add(new Help(), BorderLayout.WEST);
		jfGame.add(jpTries, BorderLayout.CENTER);
		if (WindowSize.width > 1200 && WindowSize.height > 1000)
		{
			System.out.println();
			jfGame.setSize(1000, 800);
			jfGame.setLocationRelativeTo(null);
		}
		else
		{
			jfGame.setLocation((int) (WindowSize.width*0.16), (int) (WindowSize.height*0.17));
			jfGame.pack();
			jfGame.setLocationRelativeTo(null);
		}
		jfGame.setVisible(true);
	}
	
	public static JFrame returnGame() {
		return jfGame;
	}
	
	public void tries() {
		
		JPanel tries[] = new JPanel[5];
		JTextField letters[][] = new JTextField[5][5];
		for (int i = 0; i < letters.length; i++) {
			tries[i] = new JPanel();
			for (int j = 0; j < letters[i].length; j++) {
				letters[i][j] = new JTextField("", 2);
				letters[i][j].setFont(letterFont);
				letters[i][j].setEditable(false);
				letters[i][j].setBackground(Color.CYAN);
				if (i + j > 0)
					letters[i][j].setFocusable(false);
				else
					letters[i][j].setBorder(borderColor);
				
				if (i < 4)
					letters[i][j].addKeyListener(new HandleLetter(letters[i], 
							letters[i+1], j, true));
				else
					letters[i][j].addKeyListener(new HandleLetter(letters[i], 
							letters[i], j, true));
				tries[i].add(letters[i][j]);
			}
		
		jpTries.add(tries[i]);	
	}
	}
}