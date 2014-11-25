package utils;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class DFServiceUtils {
	
	public static boolean RegisterService(Agent agent, String service_name, String service_type) {
		
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

}
