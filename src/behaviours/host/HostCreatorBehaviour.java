package behaviours.host;

import utils.Constants;
import utils.DFServiceUtils;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import agents.Ateo;
import agents.Banana;

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
				container.createNewAgent("Banana", Banana.class.getName(), new Object[0]).start();
			} catch (StaleProxyException e) {				
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				container.createNewAgent("Ateo", Ateo.class.getName(), new Object[0]).start();
			} catch (StaleProxyException e) {				
				e.printStackTrace();
			}
			break;
		default:
			DFServiceUtils.sendMsgToService(myAgent, "Que comience la fiesta", 
					Constants.GUEST_SERVICE, Constants.BEGIN_PARTY);
			System.out.println(myAgent.getLocalName() + ": Ya estamos todos!");
			System.out.println(myAgent.getLocalName() + ": Podeis empezar a comer y beber!");
			//TODO: Add host party behaviour
			stop();
			break;
		}
		state++;
	}

}
