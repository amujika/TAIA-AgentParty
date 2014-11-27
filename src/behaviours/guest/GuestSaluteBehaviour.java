package behaviours.guest;

import graphics.GraphicUtils;

import java.util.TreeMap;

import utils.Constants;
import utils.DFServiceUtils;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class GuestSaluteBehaviour extends TickerBehaviour{

	public String default_answer;
	public TreeMap<String, String> answers;	
	public String guest_salute, host_salute;
	
	
	public GuestSaluteBehaviour(Agent a) {
		super(a, Constants.REFRESH_TIME);		
	}

	private static final long serialVersionUID = 5336793530349935357L;

	protected void onTick() {	
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getConversationId() != null) {
			if (msg.getConversationId() == Constants.GREETING) {
				ACLMessage response = new ACLMessage(ACLMessage.INFORM);
				response.setConversationId(Constants.GREETING_ACK);
				response.addReceiver(msg.getSender());
				String sender = msg.getSender().getLocalName();
				if (answers.containsKey(sender)) {
					response.setContent(answers.get(sender));
				} else {
					response.setContent(default_answer);
				}
				myAgent.send(response);
				GraphicUtils.appendMessage(myAgent.getLocalName() + " a " + sender + ": " + response.getContent());
			}
			else if (msg.getConversationId() == Constants.BEGIN_PARTY) {				
				myAgent.addBehaviour(new GuestPartyBehaviour(myAgent));
				stop();
			}
		}
	}	

	public void onStart() {
		DFServiceUtils.sendMsgToService(myAgent, guest_salute, Constants.GUEST_SERVICE, Constants.GREETING);
		DFServiceUtils.sendMsgToService(myAgent, host_salute,  Constants.HOST_SERVICE,  Constants.GREETING);
	}
	
}
