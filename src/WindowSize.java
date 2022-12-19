import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

public class WindowSize {
	static int width;
	static int height;
	WindowSize(){
		DisplayMode size = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
    
		width = Integer.parseInt(size.toString().split("x")[0]);
		height = Integer.parseInt(size.toString().split("x")[1]);
	}
}
