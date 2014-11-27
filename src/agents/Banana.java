package agents;

import java.util.TreeMap;

import behaviours.guest.GuestSaluteBehaviour;
import utils.Resources;

public class Banana extends Guest{
	private static final long serialVersionUID = -812750831522086258L;
	
	protected void setup() {
		x = 200;
		y = 200;
		super.setupImage(Resources.BANANA, 0.5);
		super.setup();
		
		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);
		satisfaction = 5;
	}
	
	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Bananhola!";		
		behaviour.host_salute = "Que pasa Cheesus!";
		behaviour.guest_salute = "Saludos bananatásticos";
	}

}
