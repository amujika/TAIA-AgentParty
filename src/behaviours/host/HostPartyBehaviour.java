package behaviours.host;

import utils.Constants;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class HostPartyBehaviour extends TickerBehaviour {
	private static final long serialVersionUID = 8721067307902937591L;
	
	public HostPartyBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);		
	}

	protected void onTick() {
		//TODO: Eat
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getConversationId() != null) {
			if (msg.getConversationId() == Constants.FOOD) {
				
			} else if (msg.getConversationId() == Constants.DRINK) {
				
			}
		}
	}

}
