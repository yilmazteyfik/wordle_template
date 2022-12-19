import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class HandleData{
	File myFile;
	String word = new String();
	boolean isText = false;
	
	public HandleData(String txtFile) {
		if (txtFile.endsWith("txt") == false) {
			System.out.println("You should enter a txt file.");
		}
		
		else {
			try 
			{
				isText = true;
				InputStream fileReader = this.getClass().getResourceAsStream("words.txt");
				int i = 0;
				int h = new Random().nextInt(5757);
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
					word = String.copyValueOf(tmp);
					i++;
					if (i == h)
						break;
				}
			}
				
			catch (IOException e) {
				
				System.out.println("File not found.");
				e.getStackTrace();
			}
		}
	}	
}