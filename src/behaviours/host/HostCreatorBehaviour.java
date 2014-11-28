package behaviours.host;

import graphics.GraphicUtils;
import utils.Constants;
import utils.DFServiceUtils;
import jade.core.behaviours.TickerBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import agents.Ateo;
import agents.Banana;
import agents.Host;
import agents.NyanCat;
import agents.Waiter;

public class HostCreatorBehaviour extends TickerBehaviour{
	private static final long serialVersionUID = -1727329283961461036L;
	
	private int state = 0;
	Host myAgent;
	
	public HostCreatorBehaviour(Host a) {
		super(a, 3000);
		myAgent = a;
	}

	protected void onTick() {
		AgentContainer container = this.myAgent.getContainerController();
		try {
		switch (state) {
			case 0:
				container.createNewAgent("Banana", Banana.class.getName(), new Object[0]).start();
				break;
			case 1:			
				container.createNewAgent("Ateo", Ateo.class.getName(), new Object[0]).start();
				break;
			case 2:
				container.createNewAgent("NyanCat", NyanCat.class.getName(), new Object[0]).start();
				break;
			default:
				container.createNewAgent("Waiter", Waiter.class.getName(), new Object[0]).start();
				
				DFServiceUtils.sendMsgToService(myAgent, "Que comience la fiesta!", 
						Constants.GUEST_SERVICE, Constants.BEGIN_PARTY);
				GraphicUtils.appendMessage(myAgent.getLocalName() + ": Ya estamos todos!");
				GraphicUtils.appendMessage(myAgent.getLocalName() + ": Podeis empezar a comer y beber!");
				
				myAgent.addBehaviour(new HostPartyBehaviour(myAgent));
				myAgent.party = true;
				stop();
				break;
			}
		} catch (StaleProxyException e) {				
			e.printStackTrace();
		}
		state++;
	}

}
