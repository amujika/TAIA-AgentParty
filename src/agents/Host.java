package agents;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graphics.GraphicUtils;
import behaviours.HostMainBehaviour;
import jade.core.Agent;

public class Host extends Agent {	

	private static final long serialVersionUID = 3493143872944535412L;
	
	public JLabel image;
	
	protected void setup() {
		HostMainBehaviour main_behaviour = new HostMainBehaviour(this);
		this.addBehaviour(main_behaviour);
		
		GraphicUtils.initialize();		
		ImageIcon temporal_image = new ImageIcon("res/images/dancingjesus.gif");
		image = new JLabel(temporal_image);
		int width  = temporal_image.getIconWidth();
		int height = temporal_image.getIconHeight();
		image.setSize(width, height);
		image.setLocation(0, 0);		

		GraphicUtils.addImage(image);		
	}
	
	protected void takeDown() {
		GraphicUtils.removeImage(image);
	}
}