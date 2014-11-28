package behaviours.guest;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import utils.Constants;
import utils.DFServiceUtils;
import utils.RandomUtils;
import agents.Guest;

public class GuestPartyBehaviour extends TickerBehaviour {
	private static final long serialVersionUID = 8721067307902937591L;
	private Guest myAgent;

	public GuestPartyBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);
		myAgent = (Guest) a;
	}

	protected void onTick() {
		if (myAgent.satisfaction <= 0) {
			DFServiceUtils.sendMsgToService(myAgent, myAgent.parting_sentence, 
					Constants.HOST_SERVICE, Constants.GOODBYE);
			myAgent.blockingReceive(MessageTemplate.MatchConversationId(Constants.GOODBYE_ACK));
			myAgent.doDelete();
			return;
		}
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getConversationId() != null) {
			if (msg.getConversationId() == Constants.FOOD ||
					msg.getConversationId() == Constants.DRINK) {				
				switch (RandomUtils.range(1, 3)) {
				case 1:
					DFServiceUtils.sendMsgToService(myAgent, "No gracias", 
							Constants.WAITER_SERVICE, msg.getContent(), ACLMessage.REJECT_PROPOSAL);
					break;
				default:
					DFServiceUtils.sendMsgToService(myAgent, "Por supuesto!", 
							Constants.WAITER_SERVICE, msg.getContent(), ACLMessage.ACCEPT_PROPOSAL);
					myAgent.satisfaction--;
					
					if(msg.getConversationId() == Constants.FOOD)
						myAgent.addFood(msg.getContent());
					else
						myAgent.addDrink(msg.getContent());
					break;
				}
			}
		}
	}

}
