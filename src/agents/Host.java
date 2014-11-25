package agents;

import behaviours.HostMainBehaviour;
import jade.core.Agent;

public class Host extends Agent {	

	private static final long serialVersionUID = 3493143872944535412L;

	protected void setup() {
		HostMainBehaviour main_behaviour = new HostMainBehaviour();
		this.addBehaviour(main_behaviour);
	}
}