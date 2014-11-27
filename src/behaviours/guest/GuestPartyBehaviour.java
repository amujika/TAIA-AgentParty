package behaviours.guest;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
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
			
			
			myAgent.doDelete();
		}
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getConversationId() != null) {
			if (msg.getConversationId() == Constants.FOOD ||
					msg.getConversationId() == Constants.DRINK) {
				if(msg.getConversationId() == Constants.FOOD)
					myAgent.addFood(msg.getContent());
				else
					myAgent.addDrink(msg.getContent());
				switch (RandomUtils.range(1, 2)) {
				case 1:
					System.out.println(myAgent.getLocalName()
					+ ": ¡Qué puta mierda de " + msg.getContent() + "!");
					myAgent.satisfaction++;
					break;
				case 2:
					System.out.println(myAgent.getLocalName() + ": Ummm... "
							+ msg.getContent() + ", bastante bien.");
					myAgent.satisfaction -= 2;
					break;
				}
			}
		}
	}

}
