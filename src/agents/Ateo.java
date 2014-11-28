package agents;

import java.util.TreeMap;

import behaviours.guest.GuestSaluteBehaviour;
import utils.Resources;

public class Ateo extends Guest {
	private static final long serialVersionUID = -812750831522086258L;
	
	protected void setup() {
		x = 200;
		y = 500;
		super.setupImage(Resources.ATEO, 0.5);
		super.setup();
		
		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);
	}
	
	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Toma un panfleto anti-cristiano.";		
		behaviour.host_salute = "¡Jódete Jesus!";
		behaviour.guest_salute = "Te veo cara de capistalista, ¡compra mis libros!";
		this.parting_sentence = "Tu fiesta es horrible, me piro!";
	}

}