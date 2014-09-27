package flyinghigh.services.flights;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class CalculatingRequiredPointsIT {

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
    public void should_calculate_the_points_required_for_a_given_route() {
        String points = restTemplate.getForObject(baseUrl + "/rest/api/routes/calculatePoints?departureCode={departure}&destinationCode={destination}", String.class,"SYD","SFO");
        assertThat(points).isEqualTo("13000");
    }

    @Test
    public void should_calculate_the_points_required_for_a_trip_back() {
        String points = restTemplate.getForObject(baseUrl + "/rest/api/routes/calculatePoints?departureCode={departure}&destinationCode={destination}", String.class,"SFO","SYD");
        assertThat(points).isEqualTo("13000");
    }


    @Test
    public void should_calculate_zero_for_points_between_the_same_cities() {
        String points = restTemplate.getForObject(baseUrl + "/rest/api/routes/calculatePoints?departureCode={departure}&destinationCode={destination}", String.class,"SYD","SYD");
        assertThat(points).isEqualTo("0");
    }

}
