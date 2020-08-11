package com.lambda.orders.services;

import com.lambda.orders.models.Agent;
import com.lambda.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices
{
    @Autowired
    AgentsRepository agentrepos;

    @Override
    public Agent save(Agent agent){
        return agentrepos.save(agent);
    }
}
