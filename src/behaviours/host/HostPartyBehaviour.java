package behaviours.host;

import graphics.GraphicUtils;
import utils.Constants;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class HostPartyBehaviour extends CyclicBehaviour {
	private static final long serialVersionUID = 8721067307902937591L;
	
	public HostPartyBehaviour(Agent a) {
		super(a);		
	}

	public void action() {
		ACLMessage msg = myAgent.receive();
		if (msg != null && msg.getConversationId() != null) {
			if (msg.getConversationId() == Constants.FOOD
			 || msg.getConversationId() == Constants.DRINK) {
				GraphicUtils.appendMessage(myAgent.getLocalName() + ": Estoy a dieta, no tomaré nada");
			}else if (msg.getConversationId() == Constants.GOODBYE) {
				ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
				reply.addReceiver(msg.getSender());
				reply.setConversationId(Constants.GOODBYE_ACK);
				reply.setContent("Adios " + msg.getSender().getLocalName() + ".");
				myAgent.send(reply);
				GraphicUtils.appendMessage(myAgent.getLocalName() + ": " + msg.getContent());
			}else {
				GraphicUtils.appendMessage("WTF!");
			}
		}		
	}

}
