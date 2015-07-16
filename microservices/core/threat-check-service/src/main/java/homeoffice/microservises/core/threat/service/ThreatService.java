package homeoffice.microservises.core.threat.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import homeoffice.microservises.core.threat.model.Threat;

/**
 * Created by Matt Vanstone
 */
@RestController
public class ThreatService {

    /**
     * Sample usage: curl $HOST:$PORT/threat/1
     *
     * @param threatId
     * @return
     */
    @RequestMapping("/threat/{threatId}")
    public Threat getThreat(@PathVariable int threatId) {

        return new Threat(threatId, "name");
    }
}
