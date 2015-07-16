package test.java.se.callista.microservises.core.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PersonServiceApplication.class)
@WebAppConfiguration
public class PersonServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
