package homeoffice.microservices.composite.checkstatus.model;

import homeoffice.microservises.core.threat.model.Threat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matt Vanstone.
 */
public class ThreatAggregated {
    private int threatId;
    private String name;

    public ThreatAggregated(Threat threat) {

        // 1. Setup product info
        this.threatId = threat.getThreatId();
        this.name = threat.getName();

    }

    public int getThreatId() {
        return threatId;
    }

    public String getName() {
        return name;
    }
}
