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
public class InitializingTheAirportsIT {

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void should_instantiate_database_with_standard_airports() {
        databaseSetup.initializeAirports();
        List<Airport> airports = airportRepository.findAll();
        assertThat(airports).isNotEmpty();
    }

}
