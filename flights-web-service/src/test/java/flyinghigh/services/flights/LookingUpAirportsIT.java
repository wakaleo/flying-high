package flyinghigh.services.flights;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import flyinghigh.services.flights.services.DatabaseSetup;
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

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class LookingUpAirportsIT {

    @Autowired
    private EmbeddedWebApplicationContext server;

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private AirportRepository airportRepository;

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl;

    @Before
    public void configureBaseUrl() {
        baseUrl = "http://localhost:" + port;
        restTemplate = new RestTemplate();
        databaseSetup.initializeAirports();
    }

    @Test
    public void should_list_all_of_the_serviced_airports() {
        List<Airport> airports = airportRepository.findAll();
        assertThat(airports).isNotEmpty();
    }

}
