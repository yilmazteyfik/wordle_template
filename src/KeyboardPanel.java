import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class KeyboardPanel extends JPanel{
	
	JTextField letter[][] = new JTextField[5][5];
	static JButton letters[] = new JButton[26];
	JPanel kPanel = new JPanel(new GridLayout(2,13));
	JPanel lPanel = new JPanel(new GridLayout(5, 1));
	
	public KeyboardPanel() {
		kPanel = createUpPanel();
		lPanel = createBottomPanel();
		
	}
	protected JPanel createUpPanel() {
		Font lttrFont = new Font("serif", Font.PLAIN, 32);
		for (int i = 0 ; i < 26 ;i ++) {
			letters[i] = new JButton(Character.toString('A' + i));
			letters[i].setFont(lttrFont);
			letters[i].setBackground(Color.CYAN);
			letters[i].setFocusable(false);
			kPanel.add(letters[i]);
			letters[i].setTransferHandler(new ValueExportTransferHandler(Character.toString(i + 65)));
			int a = i;
			letters[i].addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged( MouseEvent e) {
					
					TransferHandler handle = letters[a].getTransferHandler();
					handle.exportAsDrag(letters[a], e, TransferHandler.COPY);
					
				}
				
				
			});
			
		}
		return kPanel;
	}
	
	protected JPanel createBottomPanel() {
		Font letterFont = new Font("serif", Font.PLAIN, 32);
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				letter[i][j] = new JTextField("", 2);
		
		letter[0][0].setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		for (int i = 0; i < 5; i++) {
			JPanel line = new JPanel(new FlowLayout());
			for (int j = 0; j < 5; j++) {
				if (i + j > 0)
					letter[i][j].setFocusable(false);
				letter[i][j].setEditable(false);
				letter[i][j].setBackground(Color.CYAN);
				letter[i][j].setFont(letterFont);
				if (j < 4)
				{
					ValueImportTransferHandler th = new ValueImportTransferHandler(letter[i][j+1]);
					letter[i][j].setTransferHandler(th);
					letter[i][j].addKeyListener(new HandleLetter(letter[i], null, j, false));
				}
				else if (i < 4)
				{
					ValueImportTransferHandler th = new ValueImportTransferHandler(letter[i][j-1]);
					letter[i][j].setTransferHandler(th);
					letter[i][j].addKeyListener(new HandleLetter(letter[i], letter[i+1], j, false));
				}
				else
				{
					ValueImportTransferHandler th = new ValueImportTransferHandler(null);
					letter[i][j].setTransferHandler(th);
					letter[i][j].addKeyListener(new HandleLetter(letter[i], letter[i], j, false));
				}
				line.add(letter[i][j]);
			}
			lPanel.add(line);
		}

		return lPanel;
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
			if (letters[i].getText().equals(ltr))
				letters[i].setBackground(Color.LIGHT_GRAY);
		}
	}
}