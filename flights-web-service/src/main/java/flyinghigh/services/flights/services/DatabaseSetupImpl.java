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
            Airport.called("Sydney").inCountry("Australia").withCode("SYD"),
            Airport.called("Sydney").inCountry("Melbourne").withCode("MLB"),
            Airport.called("San Francisco").inCountry("USA").withCode("SFO"),
            Airport.called("Los Angeles").inCountry("USA").withCode("LAX"),
            Airport.called("Hong Kong").inCountry("Hong Kong").withCode("HKG"),
            Airport.called("Singapore").inCountry("Singapore").withCode("SIN"),
            Airport.called("Beijing").inCountry("China").withCode("PEK"),
            Airport.called("Auckland").inCountry("New Zealand").withCode("AKL"),
            Airport.called("Wellington").inCountry("New Zealand").withCode("WLG"),
            Airport.called("Christchurch").inCountry("New Zealand").withCode("LHR"),
            Airport.called("Christchurch").inCountry("New Zealand").withCode("LHR"),
            Airport.called("Paris").inCountry("France").withCode("CDG"),
            Airport.called("Nice").inCountry("France").withCode("NIC"),
            Airport.called("Rome").inCountry("Italy").withCode("FCO"),
            Airport.called("Dubai").inCountry("UAE").withCode("DXB")
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
