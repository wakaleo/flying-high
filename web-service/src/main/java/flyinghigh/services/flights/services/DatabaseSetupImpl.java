package flyinghigh.services.flights.services;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

    private final static List<Airport> DEFAULT_AIRPORTS = ImmutableList.of(
            new Airport("Australia", "Sydney", "SYD"),
            new Airport("Australia", "Melbourne", "MLB"),
            new Airport("Australia", "Brisbane", "BNE"),
            new Airport("USA", "San Francisco", "SFO"),
            new Airport("USA", "Los Angeles", "LAX"),
            new Airport("Hong Kong", "Hong Kong", "HKG"),
            new Airport("Singapore", "Singapore", "SIN"),
            new Airport("China", "Beijing", "PEK"),
            new Airport("New Zealand", "Auckland", "AKL"),
            new Airport("New Zealand", "Wellington", "WLG"),
            new Airport("New Zealand", "Christchurch", "CHC"),
            new Airport("UK", "London", "LHR"),
            new Airport("France", "Paris", "CDG"),
            new Airport("Italy", "Rome", "FCO"),
            new Airport("UAE", "Dubai", "DXB")
    );

    private final AirportRepository airportRepository;

    @Autowired
    public DatabaseSetupImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public void initializeAirports() {
        airportRepository.deleteAll();
        airportRepository.save(DEFAULT_AIRPORTS);
    }
}
