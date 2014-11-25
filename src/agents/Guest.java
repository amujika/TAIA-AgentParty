package agents;

import utils.DFServiceUtils;
import jade.core.Agent;

public class Guest extends Agent{

	private static final long serialVersionUID = -261734589169928696L;
	
	protected void setup() {
		DFServiceUtils.RegisterService(this, "Guest", "Guest");
	}
	
}
