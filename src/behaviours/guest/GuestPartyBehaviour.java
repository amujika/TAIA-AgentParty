package behaviours.guest;

import utils.Constants;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class GuestPartyBehaviour extends TickerBehaviour {
	private static final long serialVersionUID = 8721067307902937591L;
	
	public GuestPartyBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);		
	}

	protected void onTick() {
		// TODO Eat
	}

}
