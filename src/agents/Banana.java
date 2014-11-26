package agents;

import utils.Resources;

public class Banana extends Guest{
	private static final long serialVersionUID = -812750831522086258L;
	
	protected void setup() {
		x = 200;
		y = 200;
		super.setupImage(Resources.BANANA, 0.5);
		super.setup();
	}

}
