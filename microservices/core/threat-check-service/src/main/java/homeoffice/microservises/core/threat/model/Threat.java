package homeoffice.microservises.core.threat.model;

/**
 * Created by Matt Vanstone
 */
public class Threat {
    private int threatId;
    private String name;

    public Threat() {

    }

    public Threat(int threatId, String name) {
        this.threatId = threatId;
        this.name = name;
    }

    public int getThreatId() {
        return threatId;
    }

    public void setThreatId(int threatId) {
        this.threatId = threatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
