package behaviours;

import agents.Banana;
import agents.Guest;
import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.core.behaviours.TickerBehaviour;

public class HostCreatorBehaviour extends TickerBehaviour{
	private static final long serialVersionUID = -1727329283961461036L;
	
	private int state = 0;
	
	public HostCreatorBehaviour(Agent a) {
		super(a, 1500);		
	}

	protected void onTick() {
		AgentContainer container = this.myAgent.getContainerController();
		switch (state) {
		case 0:
			try {
				container.createNewAgent("Banana", Banana.class.getName(), new Object[0]).start();;
			} catch (StaleProxyException e) {				
				e.printStackTrace();
			}
			break;
		default:
			this.stop();
			break;
		}
		state++;
	}

}
