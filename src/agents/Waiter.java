package agents;

import jade.core.Agent;

import java.util.Vector;

import utils.Constants;
import utils.DFServiceUtils;
import behaviours.guest.WaiterBehaviour;

public abstract class Waiter extends Agent{
	
	private static final long serialVersionUID = -261734589169928696L;
	private Vector<String> food, drink;
	
	protected void setup() {
		if (!DFServiceUtils.RegisterService(this, Constants.WAITER_SERVICE, this.getLocalName())) {
			System.err.println(this.getLocalName() + ": Couldn't register agent service. Killing agent...");
			this.doDelete();
		}
		food = new Vector <String>();
		drink = new Vector <String>();
		addFood();
		addDrink();
		
		WaiterBehaviour waiterBehaviour = new WaiterBehaviour(this);
		setWaiterBehaviour(waiterBehaviour);
		
		this.addBehaviour(waiterBehaviour);
	}

	protected void takeDown() {
		super.takeDown();
	}
	
	private void addFood(){
		food.addElement("Chorizo");
		food.addElement("Salchichon");
		food.addElement("Hostia");
		food.addElement("Garbanzos");
		food.addElement("Protes");
	}
	private void addDrink() {
		drink.addElement("Gazpacho");
		drink.addElement("Whisky");
		drink.addElement("Suan de Cabras");
		drink.addElement("Coca Cola");
		drink.addElement("Lágrima de mariposa con Ron añejo");
	}
	
	protected void setWaiterBehaviour(WaiterBehaviour behaviour){
		
	}
	
}
