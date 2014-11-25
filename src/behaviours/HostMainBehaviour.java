package behaviours;

import agents.Host;
import jade.core.behaviours.CyclicBehaviour;

public class HostMainBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = -219939034710645230L;

	private int i = 0;
	private Host myAgent;
	
	public HostMainBehaviour(Host agent) {
		super(agent);
		myAgent = agent;
	}
	
	public void action() {		
		myAgent.image.setLocation(i/100000, i/100000);
		i++;		
	}

}
