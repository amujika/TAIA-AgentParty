package utils;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class DFServiceUtils {
	
	public static boolean registerService(Agent agent, String service_type, String service_name) {
		
		DFAgentDescription agent_description = new DFAgentDescription();
		agent_description.setName(agent.getAID());
		ServiceDescription agent_service = new ServiceDescription();
		agent_service.setName(service_name);
		agent_service.setType(service_type);
		agent_description.addServices(agent_service);
		try {
			DFService.register(agent, agent_description);
		} catch (FIPAException e) {
			return false;
		}
		return true;
	}
	
	public static boolean unregisterService(Agent agent) {
		try {
			DFService.deregister(agent);
		} catch (FIPAException e) {
			System.out.print("Esto no deberia verse");
			return false;
		}
		return true;
	}
	
	
	public static boolean sendMsgToService(Agent sender, String content,String service, String conversation) {		
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType(service);
		template.addServices(sd);
		
		try {
			DFAgentDescription[] guests = DFService.search(sender, template);
			for (DFAgentDescription guest: guests) {
				if (guest.getName().equals(sender.getAID())) continue;
				ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
				reply.addReceiver(guest.getName());
				reply.setContent(content);
				reply.setConversationId(conversation);
				sender.send(reply);
				System.out.println(sender.getLocalName() + " a " + guest.getName().getLocalName() + ": " + reply.getContent());
			}
		} catch (FIPAException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean sendRandomMsg(Agent sender, String content, String conversation) {		
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType(Constants.GUEST_SERVICE);
		template.addServices(sd);
		
		try {
			DFAgentDescription[] guests = DFService.search(sender, template);
			if (guests.length == 0) return false;
			DFAgentDescription guest = guests[RandomUtils.range(0, guests.length - 1)];
			
			ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
			reply.addReceiver(guest.getName());
			reply.setContent(content);
			reply.setConversationId(conversation);
			sender.send(reply);
			System.out.println(sender.getLocalName() + " a " + guest.getName().getLocalName() + ": " + reply.getContent());
		} catch (FIPAException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}
}
