package agents;

import utils.Resources;

public class Banana extends Guest{
	private static final long serialVersionUID = -812750831522086258L;
	
	protected void setup() {
		x = 50;
		y = 50;
		super.setupImage(Resources.BANANA);
		super.setup();
	}

}
