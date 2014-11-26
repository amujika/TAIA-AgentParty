package behaviours;

import jade.core.behaviours.TickerBehaviour;
import utils.Constants;
import utils.RandomUtils;
import agents.Guest;

public class GuestMoveBehaviour extends TickerBehaviour{
		private static final long serialVersionUID = -219939034710645230L;

		private Guest myAgent;
		private int speed_x, speed_y;
		
		public GuestMoveBehaviour(Guest agent) {
			super(agent, Constants.REFRESH_TIME);
			myAgent = agent;
			while(speed_x + speed_y < 2) {
				randSpeed(2);
			}
		}
		
		private void randSpeed(int min) {
			do{
				speed_x = RandomUtils.range(-3, 3);
				speed_y = RandomUtils.range(-3, 3);
			} while(Math.abs(speed_x) + Math.abs(speed_y) < min);
		}
		
		protected void onTick() {		
			while (myAgent.getX() + speed_x < 0
				|| myAgent.getY() + speed_y < 0
				|| myAgent.getX() + speed_x + myAgent.getWidth() > Constants.WINDOW_WIDTH
				|| myAgent.getY() + speed_y + myAgent.getHeight()> Constants.WINDOW_HEIGHT) {
					
				randSpeed(2);
			}			
			myAgent.move(speed_x, speed_y);
			
		}
}
