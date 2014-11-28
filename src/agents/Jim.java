package agents;

import java.util.TreeMap;

import utils.Audio;
import utils.Resources;
import behaviours.guest.GuestSaluteBehaviour;

public class Jim extends Guest {
	private static final long serialVersionUID = -812750831522086258L;

	protected void setup() {
		x = 500;
		y = 200;
		super.setupImage(Resources.JIM, 0.5);
		super.setup();

		GuestSaluteBehaviour salute = new GuestSaluteBehaviour(this);
		setSalutes(salute);
		this.addBehaviour(salute);
		Audio.addSound(Resources.JIM_SOUND);
	}

	protected void setSalutes(GuestSaluteBehaviour behaviour) {
		behaviour.answers = new TreeMap<String, String>();
		behaviour.default_answer = "Baby don't hurt me";
		behaviour.host_salute = "What is love?";
		behaviour.guest_salute = "What is love?";
	}

	protected void takeDown() {
		Audio.removeSound(Resources.JIM_SOUND);
		super.takeDown();
	}
}
