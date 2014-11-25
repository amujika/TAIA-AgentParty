package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.Constants;

public class GraphicUtils {

	static JFrame window;

	public static void initialize() {
		window = new JFrame();
		window.setLayout(null);
		window.setSize(Constants.WINDOW_HEIGHT, Constants.WINDOW_WIDTH);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public static void addImage(JLabel image) {
		window.add(image);
		image.setVisible(true);
	}
	
	public static void removeImage(JLabel image) {
		image.setVisible(false);
		window.remove(image);		
	}
}
