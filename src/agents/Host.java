package agents;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.Constants;
import utils.DFServiceUtils;
import utils.Resources;
import graphics.GraphicUtils;
import behaviours.host.HostCreatorBehaviour;
import behaviours.host.HostMoveBehaviour;
import jade.core.Agent;

public class Host extends Agent {	
	private static final long serialVersionUID = 3493143872944535412L;
	
	private JLabel image;
	protected int x, y;
	
	protected void setup() {
		HostMoveBehaviour main_behaviour = new HostMoveBehaviour(this);
		this.addBehaviour(main_behaviour);
		HostCreatorBehaviour creator_behaviour = new HostCreatorBehaviour(this);
		this.addBehaviour(creator_behaviour);
		
		x =  y = 0;
		
		GraphicUtils.initialize();
		setupImage();	
		this.getContainerController();
		
		if (!DFServiceUtils.RegisterService(this, Constants.HOST_SERVICE, this.getLocalName())) {
			System.err.println(this.getLocalName() + ": Couldn't register agent service. Killing agent...");
			this.doDelete();
		}
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
	
	public void move(int new_x, int new_y) {
		x = new_x;
		y = new_y;
		image.setLocation(x, y);
	}
	
	protected void takeDown() {
		GraphicUtils.removeImage(image);
	}
}