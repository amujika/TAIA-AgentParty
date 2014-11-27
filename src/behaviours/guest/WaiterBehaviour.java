package behaviours.guest;

import utils.Constants;
import utils.DFServiceUtils;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class WaiterBehaviour extends TickerBehaviour {
	
	public String food_or_drink;
	
	private static final long serialVersionUID = 8721067307502937591L;
	
	
	public WaiterBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);		
	}

	protected void onTick() {
		DFServiceUtils.sendMsgToService(myAgent, food_or_drink, Constants.GUEST_SERVICE, Constants.GREETING);
	}

}
