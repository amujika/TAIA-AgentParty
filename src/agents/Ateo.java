package agents;

import java.util.TreeMap;

import behaviours.guest.GuestSaluteBehaviour;
import utils.Resources;

public class Ateo extends Guest {
	private static final long serialVersionUID = -812750831522086258L;
	
	protected void setup() {
		x = 200;
		y = 200;
		super.setupImage(Resources.ATEO, 0.5);
		super.setup();
		
		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);		
	}
	
	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "";		
		behaviour.host_salute = "¡Jódete Cheesus!";
		behaviour.guest_salute = "";
	}

}