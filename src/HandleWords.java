import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class HandleWords{
	String[] words = new String[5757];
	File myFile;
	
	public HandleWords() {
		try {
			InputStream fileReader = this.getClass().getResourceAsStream("words.txt");
			int i = 0;
			while(true) {
				char tmp[] = new char[5];
				int j = 0;
				while(true){
					tmp[j] = (char) fileReader.read();
					j++;
					if (j == 5)
						break;
				}
				fileReader.read();
				fileReader.read();
				words[i] = String.copyValueOf(tmp);
				i++;
				if (i == 5757)
					break;
			}
		} 
		catch (IOException ex) {
			System.out.println("File not found.");
			ex.getStackTrace();
		}
	}
}
