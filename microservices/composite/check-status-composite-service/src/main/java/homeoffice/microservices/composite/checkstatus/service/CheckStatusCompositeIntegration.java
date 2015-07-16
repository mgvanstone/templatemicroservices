package homeoffice.microservices.composite.checkstatus.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import homeoffice.microservises.core.threat.model.Threat;

import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * Created by Matt Vanstone
 */
@Component
public class CheckStatusCompositeIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(CheckStatusCompositeIntegration.class);

    @Autowired
    Util util;

    private RestTemplate restTemplate = new RestTemplate();

    // -------- //
    // THREATS  //
    // -------- //

    @HystrixCommand(fallbackMethod = "defaultThreat")
    public ResponseEntity<Threat> getThreat(int threatId) {

        URI uri = util.getServiceUrl("threat", "http://localhost:8081/threat");
        String url = uri.toString() + "/threat/" + threatId;
        LOG.debug("GetThreat from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        LOG.debug("GetThreat http-status: {}", resultStr.getStatusCode());
        LOG.debug("GetThreat body: {}", resultStr.getBody());

        Threat threat = response2Threat(resultStr);
        LOG.debug("GetThreat.id: {}", threat.getThreatId());

        return util.createOkResponse(threat);
    }
    
    /**
     * Fallback method for getThreat()
     *
     * @param threatId
     * @return
     */
    public ResponseEntity<Threat> defaultThreat(int threatId) {
        LOG.warn("Using fallback method for threat-service");
        return util.createResponse(null, HttpStatus.BAD_GATEWAY);
    }

    // ----- //
    // UTILS //
    // ----- //

    /*
     * TODO: Extract to a common util-lib
     */

/*    private ObjectReader productReader = null;
    private ObjectReader getProductReader() {

        if (productReader != null) return productReader;

        ObjectMapper mapper = new ObjectMapper();
        return productReader = mapper.reader(Product.class);
    }

    private ObjectReader reviewsReader = null;
    private ObjectReader getReviewsReader() {
        if (reviewsReader != null) return reviewsReader;

        ObjectMapper mapper = new ObjectMapper();
        return reviewsReader = mapper.reader(new TypeReference<List<Review>>() {});
    }*/

/**    public Product response2Product(ResponseEntity<String> response) {
        try {
            return getProductReader().readValue(response.getBody());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }**/
    
    
    private ObjectReader threatReader = null;
    private ObjectReader getThreatReader() {

        if (threatReader != null) return threatReader;

        ObjectMapper mapper = new ObjectMapper();
        return threatReader = mapper.reader(Threat.class);
    }
    
    public Threat response2Threat(ResponseEntity<String> response) {
        try {
            return getThreatReader().readValue(response.getBody());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
// FIXME: DOESN'T WORK. GIVER ERORS LIKE: Caused by: java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to se.callista.microservises.core.recommendation.model.Recommendation
//    private <T> T responseString2Type(ResponseEntity<String> response) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            T object = mapper.readValue(response.getBody(), new TypeReference<T>() {});
//            return object;
//
//        } catch (IOException e) {
//            LOG.warn("IO-err. Failed to read JSON", e);
//            throw new RuntimeException(e);
//
//        } catch (RuntimeException re) {
//            LOG.warn("RTE-err. Failed to read JSON", re);
//            throw re;
//        }
//    }
//
//    /**
//     * TODO: DO WE REALLY NEED THIS ONE???
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    private <T> List<T> responseString2List(ResponseEntity<String> response) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            List<T> list = mapper.readValue(response.getBody(), new TypeReference<List<T>>() {});
//            return list;
//
//        } catch (IOException e) {
//            LOG.warn("IO-err. Failed to read JSON", e);
//            throw new RuntimeException(e);
//
//        } catch (RuntimeException re) {
//            LOG.warn("RTE-err. Failed to read JSON", re);
//            throw re;
//        }
//    }
//

}