package agents;

import graphics.GraphicUtils;
import jade.core.Agent;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.Constants;
import utils.DFServiceUtils;
import utils.Resources;
import behaviours.guest.WaiterBehaviour;

public class Waiter extends Agent{
	
	private static final long serialVersionUID = -261734589169928696L;
	public Vector<String> food, drink;
	protected JLabel image;
	
	protected void setup() {
		if (!DFServiceUtils.registerService(this, Constants.WAITER_SERVICE, this.getLocalName())) {
			System.err.println(this.getLocalName() + ": Couldn't register agent service. Killing agent...");
			this.doDelete();
		}
		food = new Vector <String>();
		drink = new Vector <String>();
		addFood();
		addDrink();
		setupImage(Resources.WAITER, 1);
		this.addBehaviour(new WaiterBehaviour(this));
	}
	
	protected void setupImage(String file_name, double size) {

		ImageIcon temporal_image = new ImageIcon(file_name);

		int width = (int) (temporal_image.getIconWidth() * size);
		int height = (int) (temporal_image.getIconHeight() * size);
		Image img = temporal_image.getImage().getScaledInstance(width, height,
				Image.SCALE_DEFAULT);
		image = new JLabel(new ImageIcon(img));
		image.setSize(image.getPreferredSize());
		image.setLocation(0, 0);

		GraphicUtils.addImage(image);
	}
	
	private void addFood(){
		food.addElement("Chorizo");
		food.addElement("Salchichon");
		food.addElement("Hostia");
		food.addElement("Garbanzos");
		food.addElement("Protes");
	}
	private void addDrink() {
		drink.addElement("Gazpacho");
		drink.addElement("Whisky");
		drink.addElement("Suan de Cabras");
		drink.addElement("Coca Cola");
		drink.addElement("Lágrima de mariposa con Ron añejo");
	}	
	
	protected void takeDown() {	
		StringBuilder temp = new StringBuilder();
		temp.append(this.getLocalName() + " ha servido ");
		for (int i = 0; i < drink.size(); ++i) {
			food.add(drink.get(i));
		}
		for (int i = 0; i < food.size(); ++i) {
			if (i != 0) temp.append(", ");
			temp.append(food.get(i));
		}		
		temp.append(".");
		GraphicUtils.appendMessage(temp.toString());
		GraphicUtils.removeImage(image);
	}
}
