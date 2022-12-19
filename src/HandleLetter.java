import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HandleLetter implements KeyListener{

	Border borderColor = BorderFactory.createLineBorder(Color.blue, 2);
	Border defaultBorder;
	final String orjWord = WordFile.wordFile.word;
	String word = WordFile.wordFile.word;
	boolean isEnd = false;
	boolean isWord = false;
	boolean found = false;
	boolean isKeyboard;

	JTextField[] letter;
	int index;
	JTextField[] nextLine;
	String input;

	public HandleLetter(JTextField letter[], JTextField[] nextLine, int index, boolean isKeyboard) {
		super();
		this.letter = letter;
		this.index = index;
		this.nextLine = nextLine;
		this.isKeyboard = isKeyboard;
		defaultBorder = new JTextField("", 2).getBorder();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			check(e);
			if (index == 4) {
				if(!found && isWord && letter != nextLine) {
				nextLine[0].setFocusable(true);
				nextLine[0].setBorder(borderColor);
				letter[4].setBorder(letter[3].getBorder());
				nextLine[0].grabFocus();
				}
				else{
					 String input =  letter[0].getText() + letter[1].getText() + letter[2].getText()
								+ letter[3].getText() + letter[4].getText();
					 if ((input.equals(orjWord) || letter == nextLine) && orjWord.length() > 0)
					 {
						 try {
								Thread.sleep(250);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						 if (input.equals(orjWord)) {
							 WinningEnd win;
							 if (isKeyboard) {
								 KeyboardGame.score = (long) (900000/Math.sqrt(System.currentTimeMillis() - KeyboardGame.start));
								 win = new WinningEnd(KeyboardGame.returnGame());
							 }
							 else {
								 DragDropGame.score = (long) (900000/Math.sqrt(System.currentTimeMillis() - DragDropGame.start));
								 win = new WinningEnd(DragDropGame.returnGame());
							 }
							 win.pack();
							 win.setLocationRelativeTo(null);
							 win.setResizable(false);
							 win.setVisible(true);
						 }
						 else if (isWord){
							 LosingEnd lose;
							 if (isKeyboard)
								 lose = new LosingEnd(KeyboardGame.returnGame(), orjWord);
							 else
								 lose = new LosingEnd(DragDropGame.returnGame(), orjWord);
							 lose.pack();
							 lose.setLocationRelativeTo(null);
							 lose.setResizable(false);
							 lose.setVisible(true);
						 }
					 }
				 }
				
			}
		}
			
	
		else if (e.getKeyCode() == 8 && index > 0) {
			 if (letter[index].getText().length() == 0) {
				 letter[index-1].setText("");
				 letter[index-1].setFocusable(true);
				 letter[index].setBorder(letter[index-1].getBorder());
				 letter[index-1].setBorder(borderColor);
				 letter[index-1].requestFocus();
				 letter[index].setFocusable(false);
			 }
			 else {
				 letter[index].setText("");
			 }
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(orjWord);
		 if (Character.isAlphabetic(e.getKeyChar()) && isKeyboard) {
			if (letter[index].getText().equals(""))
				isEnd = false;
			
			if (isEnd == false) {
				letter[index].setText((e.getKeyChar() + "").toUpperCase());
				isEnd = true;
			}
			
			if (index < 4 && letter[index+1].getText().equals(""))
			{
				letter[index].setFocusable(false);
				letter[index].setBorder(letter[index+1].getBorder());
				letter[index+1].setFocusable(true);
				letter[index+1].setBorder(borderColor);
				letter[index+1].grabFocus();
			}

		 }	
	}
	
	public void check(KeyEvent e) {
		String input =  letter[0].getText() + letter[1].getText() + letter[2].getText()
				+ letter[3].getText() + letter[4].getText();
		HandleWords allWords = new HandleWords();

		for (int i = 0; i < allWords.words.length; i++) {
			if(input.equals(allWords.words[i])) {
				isWord = true;
				break;
			}
		}
		
		if(isWord == false)
		{
			for (int i = 0; i < 5; i++) {
				letter[i].setText("");
				letter[i].setBorder(defaultBorder);
				letter[i].setFocusable(false);
			}
			letter[0].setFocusable(true);
			letter[0].setBorder(borderColor);
			letter[0].grabFocus();
			WordWarning warning = new WordWarning("Warning");
			warning.pack();
			warning.setLocationRelativeTo(null);
			warning.setResizable(false);
			warning.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			warning.setVisible(true);
			
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			letter[i].setFocusable(false);
			letter[i].setBorder(letter[0].getBorder());
			if(letter[i].getText().equals(word.charAt(i)+ "")) {
				letter[i].setBackground(Color.GREEN);
				if (isKeyboard)
					Keyboard.makeGreen(letter[i].getText());
				else
					KeyboardPanel.makeGreen(letter[i].getText());
				char[] wordChar = word.toCharArray();
				wordChar[i] = '.';
				word = String.valueOf(wordChar);
			}
			
			else if((word.contains(letter[i].getText()) &&
			 letter[i].getText().length() > 0)){
				boolean isThere = false;
				if (input.substring(i+1).contains(letter[i].getText()))
				{
					for (int j = i + 1; j < letter.length; j++) {
						if(input.charAt(j) == word.charAt(j))
							isThere = true;
						
					}
				}
				if(!isThere)
				{
					letter[i].setBackground(Color.YELLOW);
					if (isKeyboard)
						Keyboard.makeYellow(letter[i].getText());
					
					else
						KeyboardPanel.makeYellow(letter[i].getText());
					if (word.indexOf(letter[i].getText()) > -1)
					{
						char[] wordChar = word.toCharArray();
						wordChar[word.indexOf(letter[i].getText())] = ',';
						word = String.valueOf(wordChar);
					}
				}
				else {
					letter[i].setBackground(Color.LIGHT_GRAY);
					if (isKeyboard)
						Keyboard.makeGray(letter[i].getText());
					else
						KeyboardPanel.makeGray(letter[i].getText());
				}
			}
			
			else {
				letter[i].setBackground(Color.LIGHT_GRAY);
				if (isKeyboard)
					Keyboard.makeGray(letter[i].getText());
				else
					KeyboardPanel.makeGray(letter[i].getText());
			}
		}
		
		if (input.equals(orjWord))
			found = true;
	}
}
