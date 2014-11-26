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
		int new_x = (int)(Math.sin(this.getTickCount()/10.0)*50)+350;
		int new_y = (int)(Math.cos(this.getTickCount()/10.0)*50)+130;
		myAgent.move(new_x, new_y);		
	}
}
