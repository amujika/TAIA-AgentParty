package agents;

import graphics.GraphicUtils;
import jade.core.Agent;

import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.Constants;
import utils.DFServiceUtils;
import utils.Resources;
import behaviours.host.HostCreatorBehaviour;
import behaviours.host.HostMoveBehaviour;
import behaviours.host.HostSaluteBehaviour;

public class Host extends Agent {	
	private static final long serialVersionUID = 3493143872944535412L;
	
	private JLabel image;
	protected int x, y;
	
	protected void setup() {
		HostSaluteBehaviour salute_behaviour = new HostSaluteBehaviour(this);
		setSalutes(salute_behaviour);
		this.addBehaviour(new HostMoveBehaviour(this));		
		this.addBehaviour(new HostCreatorBehaviour(this));				
		this.addBehaviour(salute_behaviour);		
		
		x = y = 0;
		
		GraphicUtils.initialize();
		setupImage();	
		
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
	
	public void setPos(int new_x, int new_y) {
		x = new_x;
		y = new_y;
		image.setLocation(x, y);
	}
	
	protected void setSalutes(HostSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Vendo droga... bendita.";
		behaviour.answers.put("Ateo", "¡Vuelve al parque, Ateo!");
	}
	
	protected void takeDown() {
		GraphicUtils.removeImage(image);
	}
}