package agents;

import graphics.GraphicUtils;
import jade.core.Agent;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.Constants;
import utils.DFServiceUtils;
import behaviours.guest.GuestMoveBehaviour;
import behaviours.guest.GuestPartyBehaviour;
import behaviours.guest.GuestSaluteBehaviour;

public abstract class Guest extends Agent {
	private static final long serialVersionUID = -261734589169928696L;

	protected JLabel image;
	protected int x, y;
	public Vector<String> food, drink;
	public int satisfaction;

	protected abstract void setSalutes(GuestSaluteBehaviour behaviour);

	protected void setup() {
		if (!DFServiceUtils.RegisterService(this, Constants.GUEST_SERVICE,
				this.getLocalName())) {
			System.err.println(this.getLocalName()
					+ ": Couldn't register agent service. Killing agent...");
			this.doDelete();
		}
		food = new Vector<String>();
		drink = new Vector<String>();

		this.addBehaviour(new GuestMoveBehaviour(this));
		this.addBehaviour(new GuestPartyBehaviour(this));
	}

	protected void setupImage(String file_name, double size) {

		ImageIcon temporal_image = new ImageIcon(file_name);

		int width = (int) (temporal_image.getIconWidth() * size);
		int height = (int) (temporal_image.getIconHeight() * size);
		Image img = temporal_image.getImage().getScaledInstance(width, height,
				Image.SCALE_DEFAULT);
		image = new JLabel(new ImageIcon(img));
		image.setSize(image.getPreferredSize());
		image.setLocation(x, y);

		GraphicUtils.addImage(image);
	}

	public void move(int delta_x, int delta_y) {
		x += delta_x;
		y += delta_y;
		image.setLocation(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getWidth() {
		return image.getWidth();
	}

	protected void takeDown() {
		// TODO: Desregistrar el agente
		GraphicUtils.removeImage(image);
	}

	public void addFood(String newFood) {
		food.addElement(newFood);
	}

	public void addDrink(String newDrink) {
		drink.addElement(newDrink);
	}

}
