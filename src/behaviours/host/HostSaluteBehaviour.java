package behaviours.host;

import graphics.GraphicUtils;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.TreeMap;

import agents.Host;
import utils.Constants;

public class HostSaluteBehaviour extends CyclicBehaviour {
	
	private static final long serialVersionUID = -862201057201867793L;
	
	public String default_answer;
	public TreeMap<String, String> answers;	
	
	private Host myAgent;
	
	public HostSaluteBehaviour(Host a) {
		super(a);
		myAgent = a;
	}
	
	public void action() {
		if(myAgent.party) {
			myAgent.removeBehaviour(this);
		}
		ACLMessage msg = myAgent.receive();
		if(msg != null && msg.getConversationId() != null) {
			if(msg.getConversationId().compareTo(Constants.GREETING) == 0) {
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
		}
	}
}
