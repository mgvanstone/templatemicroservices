package homeoffice.microservices.composite.checkstatus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homeoffice.microservices.composite.checkstatus.model.ThreatAggregated;
import homeoffice.microservises.core.threat.model.Threat;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Matt Vanstone.
 */
@RestController
public class CheckStatusCompositeService {

    private static final Logger LOG = LoggerFactory.getLogger(CheckStatusCompositeService.class);

    @Autowired
    CheckStatusCompositeIntegration integration;

    @Autowired
    Util util;

    @RequestMapping("/")
    public String getThreat() {
        return "{\"timestamp\":\"" + new Date() + "\",\"content\":\"Hello from Threat\"}";
    }

    @RequestMapping("/check/{threatId}")
    public ResponseEntity<ThreatAggregated> getThreatStatus(@PathVariable int threatId) {

        // First get mandatory threat information
        ResponseEntity<Threat> threatResult = integration.getThreat(threatId);

        if (!threatResult.getStatusCode().is2xxSuccessful()) {
            // We can't proceed, return whatever fault we got from the getThreat call
            return util.createResponse(null, threatResult.getStatusCode());
        }

        return util.createOkResponse(new ThreatAggregated(threatResult.getBody()));
    }
}