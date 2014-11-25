package behaviours;

import jade.core.behaviours.TickerBehaviour;
import utils.Constants;
import agents.Host;

public class HostMainBehaviour extends TickerBehaviour{
	private static final long serialVersionUID = -219939034710645230L;

	private Host myAgent;
	
	public HostMainBehaviour(Host agent) {
		super(agent, Constants.REFRESH_TIME);
		myAgent = agent;
	}
	
	protected void onTick() {
		myAgent.move(1, 1);		
	}
}
