package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import utils.Constants;
import utils.Resources;

public class GraphicUtils {

	static JFrame window;
	static JFrame msgWindow;

	public static void initialize() {
		window = new JFrame();
		window.setLayout(null);
		window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		System.out.println("Adrian");
		// MESSAGE WINDOW
		msgWindow = new JFrame();
		msgWindow.setLayout(null);
		msgWindow.setSize(Constants.MSG_WINDOW_WIDTH, 
						  Constants.MSG_WINDOW_HEIGHT);
		msgWindow.setLocationRelativeTo(window);
		msgWindow.setLocation(0, Constants.WINDOW_HEIGHT + 60);
		JTextArea msg = new JTextArea();
		msg.setEditable(false);
		msg.setLocation(10, 10);
		msg.setSize(Constants.MSG_WINDOW_WIDTH, 
					Constants.MSG_WINDOW_HEIGHT);
		msg.setText("Hola\nHola\nHola");
		msgWindow.add(msg);
		
		ImageIcon backgroundImage = new ImageIcon(Resources.BACKGROUND);	
		Image img = backgroundImage.getImage().getScaledInstance(Constants.WINDOW_WIDTH, 
				Constants.WINDOW_HEIGHT, Image.SCALE_DEFAULT);
		JLabel background = new JLabel(new ImageIcon(img));		
		background.setSize(background.getPreferredSize());
		window.setContentPane(background);

		window.setVisible(true);
		msgWindow.setVisible(true);
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
