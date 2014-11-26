package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.Constants;

public class GraphicUtils {

	static JFrame window;

	public static void initialize() {
		window = new JFrame();
		window.setLayout(null);
		window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		window.setLocationRelativeTo(null);
		ImageIcon backgroundImage = new ImageIcon("res/images/Mybrainhurts.gif");	
		int width  = Constants.WINDOW_WIDTH;
		int height = Constants.WINDOW_HEIGHT;
		Image img = backgroundImage.getImage().getScaledInstance(width, height,
	            Image.SCALE_DEFAULT);
		JLabel background = new JLabel(new ImageIcon(img));
		
		background.setSize(background.getPreferredSize());
		window.setContentPane(background);
		//window.add(background);
		//window.setComponentZOrder(background, 100);
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
