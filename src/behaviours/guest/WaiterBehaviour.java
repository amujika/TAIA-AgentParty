package behaviours.guest;

import jade.core.behaviours.TickerBehaviour;
import utils.Constants;
import utils.DFServiceUtils;
import utils.RandomUtils;
import agents.Waiter;

public class WaiterBehaviour extends TickerBehaviour {
	
	private Waiter myAgent;
	private boolean f_or_d;
	
	private static final long serialVersionUID = 8721067307502937591L;
	
	
	public WaiterBehaviour(Waiter a) {
		super(a, 1500);
		myAgent = a;
		f_or_d = true;
	}

	protected void onTick() {
		String food = myAgent.food.get(RandomUtils.range(0, myAgent.food.size() - 1));
		String drink = myAgent.drink.get(RandomUtils.range(0, myAgent.drink.size() - 1));
		if (f_or_d) {
			if(!DFServiceUtils.sendRandomMsg(myAgent, food, Constants.FOOD))
				myAgent.doDelete();
		} else {
			if(!DFServiceUtils.sendRandomMsg(myAgent, drink, Constants.DRINK))
				myAgent.doDelete();
		}
		f_or_d = !f_or_d;
	}

}
