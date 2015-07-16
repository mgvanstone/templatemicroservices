package homeoffice.microservises.core.threat;

import homeoffice.microservises.core.threat.ThreatServiceApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThreatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreatServiceApplication.class, args);
    }
}
