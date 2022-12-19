import java.awt.BorderLayout;

import javax.swing.JFrame;

public class DragDropGame {
	static long score;
	static HighScores scoreboard;
	static long start;
	ClockText clock = new ClockText();
	KeyboardPanel panel = new KeyboardPanel();
	static JFrame frame;
	
	public void initializeGame() {
		start = System.currentTimeMillis();
		scoreboard = new HighScores(false);
		frame = new JFrame("Drag and Drop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel.lPanel, BorderLayout.CENTER);
		frame.add(panel.kPanel, BorderLayout.SOUTH);
		frame.add(clock, BorderLayout.NORTH);
		frame.add(new Help(), BorderLayout.WEST);
		frame.add(scoreboard, BorderLayout.EAST);
		if (WindowSize.width > 1200 && WindowSize.height > 1000)
		{
			System.out.println();
			frame.setSize(1000, 800);
			frame.setLocationRelativeTo(null);
		}
		else
		{
			frame.setLocation((int) (WindowSize.width*0.16), (int) (WindowSize.height*0.17));
			frame.pack();
			frame.setLocationRelativeTo(null);
		}
		frame.setVisible(true);
	}
	
	public static JFrame returnGame() {
		return frame;
	}
}
