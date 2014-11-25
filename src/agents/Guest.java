package agents;

import graphics.GraphicUtils;
import jade.core.Agent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.DFServiceUtils;

public class Guest extends Agent{
	private static final long serialVersionUID = -261734589169928696L;
	
	protected JLabel image;
	protected int x, y;
	
	protected void setup() {
		if (!DFServiceUtils.RegisterService(this, this.getLocalName(), this.getLocalName())) {
			System.err.println(this.getLocalName() + ": Couldn't register agent service. Killing agent...");
			this.doDelete();
		}
		x = y = 0;
	}
	
	protected void setupImage(String file_name) {
		
		ImageIcon temporal_image = new ImageIcon(file_name);
		image = new JLabel(temporal_image);
		int width  = temporal_image.getIconWidth();
		int height = temporal_image.getIconHeight();
		image.setSize(width, height);
		image.setLocation(x, y);
		System.out.print("aaaaa");
		GraphicUtils.addImage(image);
	}
	
	protected void takeDown() {
		//TODO: Desregistrar el agente y borrar la imagen
	}
	
}
