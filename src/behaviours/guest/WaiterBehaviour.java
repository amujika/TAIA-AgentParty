package behaviours.guest;

import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;
import utils.DFServiceUtils;
import utils.RandomUtils;
import agents.Waiter;

public class WaiterBehaviour extends TickerBehaviour {
	
	private Waiter myAgent;
	private int f_or_d;
	
	private static final long serialVersionUID = 8721067307502937591L;
	
	
	public WaiterBehaviour(Waiter a) {
		super(a, 1500);
		myAgent = a;
		f_or_d = 0;
	}

	protected void onTick() {
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL)
			myAgent.served.add(msg.getConversationId());
		
		String food = myAgent.food.get(RandomUtils.range(0, myAgent.food.size() - 1));
		String drink = myAgent.drink.get(RandomUtils.range(0, myAgent.drink.size() - 1));
		switch (f_or_d) {
		case 0:
			if(!DFServiceUtils.sendRandomMsg(myAgent, food, Constants.FOOD))
				myAgent.doDelete();
			break;
		case 1:
			if(!DFServiceUtils.sendRandomMsg(myAgent, drink, Constants.DRINK))
				myAgent.doDelete();
			break;
		case 2:
			DFServiceUtils.sendMsgToService(myAgent, "Quieres " + food + "?", 
					Constants.HOST_SERVICE, Constants.FOOD, ACLMessage.REJECT_PROPOSAL);
			break;
		}
		f_or_d = (f_or_d + 1) % 3;
	}

}
