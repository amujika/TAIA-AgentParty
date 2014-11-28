package graphics;

import java.awt.Color;
import java.awt.Image;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import utils.Constants;
import utils.RandomUtils;
import utils.Resources;

public class GraphicUtils {

	static JFrame window;
	static JScrollPane textArea;
	static TreeMap<String, Color> colors;

	public static void initialize() {
		colors = new TreeMap<String, Color>();
		window = new JFrame();
		window.setLayout(null);
		window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT + Constants.TEXT_HEIGHT);
		
		ImageIcon backgroundImage = new ImageIcon(Resources.BACKGROUND);	
		Image img = backgroundImage.getImage().getScaledInstance(Constants.WINDOW_WIDTH, 
				Constants.WINDOW_HEIGHT + Constants.TEXT_HEIGHT, Image.SCALE_DEFAULT);
		JLabel background = new JLabel(new ImageIcon(img));		
		background.setSize(background.getPreferredSize());
		window.setContentPane(background);
		
		textArea = new JScrollPane();
		textArea.setSize(Constants.WINDOW_WIDTH, 200);
		textArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setAutoscrolls(true);
		JTextPane text = new JTextPane();
		text.setSize(Constants.WINDOW_WIDTH, Constants.TEXT_HEIGHT);
		text.setEditable(false);
		textArea.setViewportView(text);
		textArea.setLocation(0, Constants.WINDOW_HEIGHT);
		window.add(textArea);
		
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
	
	public static void appendMessage(String msg) {
		JTextPane text = (JTextPane) textArea.getViewport().getView();
		String sender = msg.split("[\\s+:]")[0];
		Color color;
		if (!colors.containsKey(sender)) {
			colors.put(sender, RandomUtils.randomColor());
		} 
		color = colors.get(sender);
		StyledDocument doc = text.getStyledDocument();
		Style style = doc.addStyle("Main", null); 
		StyleConstants.setForeground(style, color); 
		try {
			doc.insertString(doc.getLength(), "  " + msg + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		JScrollBar jsbar = textArea.getVerticalScrollBar();
		jsbar.setValue(jsbar.getMaximum());
	}
}
