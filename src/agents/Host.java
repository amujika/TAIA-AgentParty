package agents;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.Resources;
import graphics.GraphicUtils;
import behaviours.HostCreatorBehaviour;
import behaviours.HostMainBehaviour;
import jade.core.Agent;

public class Host extends Agent {	
	private static final long serialVersionUID = 3493143872944535412L;
	
	private JLabel image;
	private int x, y;
	
	protected void setup() {
		HostMainBehaviour main_behaviour = new HostMainBehaviour(this);
		this.addBehaviour(main_behaviour);
		HostCreatorBehaviour creator_behaviour = new HostCreatorBehaviour(this);
		this.addBehaviour(creator_behaviour);
		
		x =  y = 0;
		
		GraphicUtils.initialize();
		setupImage();	
		this.getContainerController();
	}
	
	private void setupImage() {
				
		ImageIcon temporal_image = new ImageIcon(Resources.JESUS);
		image = new JLabel(temporal_image);
		int width  = temporal_image.getIconWidth();
		int height = temporal_image.getIconHeight();
		image.setSize(width, height);
		image.setLocation(x, y);
		
		GraphicUtils.addImage(image);
	}
	
	public void move(int delta_x, int delta_y) {
		x += delta_x;
		y += delta_y;
		image.setLocation(x, y);
	}
	
	protected void takeDown() {
		GraphicUtils.removeImage(image);
	}
}