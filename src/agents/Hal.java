package agents;

import java.util.TreeMap;

import utils.Resources;
import behaviours.guest.GuestSaluteBehaviour;

public class Hal extends Guest{
	private static final long serialVersionUID = -812750831522086258L;

	protected void setup() {
		x = 500;
		y = 200;
		super.setupImage(Resources.HAL, 1.5);
		super.setup();

		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);
	}

	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Saludos";
		behaviour.host_salute = "Saludos";
		behaviour.guest_salute = "Saludos";
		this.parting_sentence = "Estabais hablando mal de mi, me voy.";
	}

	protected void takeDown() {
		super.takeDown();
	}
}
