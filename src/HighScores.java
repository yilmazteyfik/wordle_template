import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScores extends JPanel{
	JLabel jlScores[] = new JLabel[5];
	String names[] = new String[100];
	static int scores[] = new int[100];
	boolean isKeyboard;
	
	Font scoreFont = new Font("serif", Font.PLAIN, 28);
	public HighScores(boolean isKeyboard) {
		this.isKeyboard = isKeyboard;
		this.setLayout(new GridLayout(6, 1));
		this.setBackground(new Color(255,160,122));
		for (int i = 0; i < jlScores.length; i++) {
			jlScores[i] = new JLabel();
			scores[i] = 0;
			names[i] = "";
		}
		getScores();
		JLabel title = new JLabel("       High Scores      ");
		title.setFont(new Font("serif", Font.PLAIN, 32));
		this.add(title);
		for (int i = 0; i < 5; i++) {
			if (scores[i] == 0)
				break;
			jlScores[i].setText("       " + (i+1) + ". " + names[i] + " " + scores[i] + "        ");
			jlScores[i].setFont(scoreFont);
			this.add(jlScores[i]);
		}
	}
	
	private void getScores(){
		InputStream fileReader = this.getClass().getResourceAsStream("scores.txt");
		int i = 0;
		char h;
		try {
			while(true) {
				InputStreamReader isReader = new InputStreamReader(fileReader); 
				BufferedReader reader = new BufferedReader(isReader);
				String tmp;
				while((tmp = reader.readLine()) != null && tmp.length() > 0){
					names[i] = tmp.split(" ")[0];
					scores[i] = Integer.parseInt(tmp.split(" ")[1]);
					i++;
				}
				if (tmp == null)
					break;
			}
		} 
		catch (IOException e) {
			// TODO: handle exception
		}
		sortScores();
	}
	
	void sortScores() {
		for (int j = 0; j < scores.length; j++) {
			if(scores[j] == 0)
				break;
			for (int j2 = j + 1; j2 < scores.length; j2++) {
				if (scores[j2] > scores[j]) {
					String tmpStr = names[j];
					names[j] = names[j2];
					names[j2] = tmpStr;
					int tmp = scores[j];
					scores[j] = scores[j2];
					scores[j2] = tmp;
					
				}
			}
		}
	}
	void addScores() {
		long sc;
		if (isKeyboard)
			sc = KeyboardGame.score;
		else
			sc = DragDropGame.score;
		URL u = getClass().getResource("scores.txt");
		int i = 0;
		char h;
		try {
			File f = new File(u.toURI());
			FileWriter fw = new FileWriter(f.getAbsolutePath(), true);
			BufferedWriter writer = new BufferedWriter(fw);
			if (!WinningEnd.save.getText().contains(" ") && WinningEnd.save.getText().length() >= 3) {
				if (f.length() != 0)
					writer.write("\n");
				writer.write(WinningEnd.save.getText() + " " + sc);
			}
			else
				writer.write("\nPlayer " + sc);
			writer.close();
		} 
		catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
}
