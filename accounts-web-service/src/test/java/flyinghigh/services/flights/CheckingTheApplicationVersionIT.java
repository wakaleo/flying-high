package flyinghigh.services.flights;

import flyinghigh.services.accounts.AccountsApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.fest.assertions.api.Assertions.assertThat;

//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class CheckingTheApplicationVersionIT {

    @Autowired
    private EmbeddedWebApplicationContext server;

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl;

    @Before
    public void configureBaseUrl() {
        baseUrl = "http://localhost:" + port;
        restTemplate = new RestTemplate();
    }

    @Test
    public void should_display_the_current_application_version() {
        String about = restTemplate.getForObject(baseUrl + "/about", String.class);
        assertThat(about).contains("ACCOUNTS WEB SERVICE VERSION");
    }

}
