package flyinghigh.services.flights;

import com.mongodb.util.Hash;
import flyinghigh.services.flights.domain.Airport;
import org.junit.Before;
import org.junit.Ignore;
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

import java.util.HashMap;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class FindingDestinationAndDepartureAirports {

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
    @Ignore
    public void should_find_airports_based_on_return_routes() {
        List<HashMap> destinations = restTemplate.getForObject(baseUrl + "/rest/api/routes/from?departureCode={departureCode}", List.class, "WLG");

        assertThat(destinations).isNotEmpty();
        destinations.stream().forEach(
                destination -> assertThat(destination.get("code")).isNotEqualTo("WLG")
        );
    }

    @Test
    public void should_find_airports_with_flights_from_a_given_destination() {
        List<HashMap> destinations = restTemplate.getForObject(
                baseUrl + "/rest/api/routes/from?departureCode={departureCode}", List.class, "SYD");

        assertThat(destinations).isNotEmpty();
        destinations.stream().forEach(
                destination -> assertThat(destination.get("code")).isNotEqualTo("SYD")
        );
    }

    @Test
    public void should_find_airports_with_flights_to_a_given_destination() {
        List<HashMap> destinations = restTemplate.getForObject(baseUrl + "/rest/api/routes/to?destinationCode={destinationCode}", List.class, "SYD");

        assertThat(destinations).isNotEmpty();
        destinations.stream().forEach(
                destination -> assertThat(destination.get("code")).isNotEqualTo("SYD")
        );
    }


}
