package agents;

import java.util.TreeMap;

import utils.Audio;
import utils.Resources;
import behaviours.guest.GuestSaluteBehaviour;

public class NyanCat extends Guest{
	private static final long serialVersionUID = -812750831522086258L;

	protected void setup() {
		x = 200;
		y = 200;
		super.setupImage(Resources.NYAN, 0.5);
		super.setup();

		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);
		//Audio.addSound(Resources.BANANA_SOUND);
	}

	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Nyan!";
		behaviour.host_salute = "Nyan Nyan!";
		behaviour.guest_salute = "Nyan Nyan Nyan";
	}

	protected void takeDown() {
		//Audio.removeSound(Resources.BANANA_SOUND);
		super.takeDown();
	}
}
