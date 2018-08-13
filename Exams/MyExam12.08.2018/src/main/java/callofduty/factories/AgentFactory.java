package callofduty.factories;

import callofduty.interfaces.Agent;
import callofduty.domain.agents.NoviceAgent;

public final class AgentFactory {

    private AgentFactory() {
    }

    public static Agent create(String id, String name) {
        return new NoviceAgent(id, name);
    }
}
