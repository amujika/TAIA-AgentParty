package behaviours.guest;

import utils.Constants;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class WaiterBehaviour extends TickerBehaviour {
	private static final long serialVersionUID = 8721067307502937591L;
	
	public WaiterBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);		
	}

	protected void onTick() {
		// TODO Eat
	}

}
