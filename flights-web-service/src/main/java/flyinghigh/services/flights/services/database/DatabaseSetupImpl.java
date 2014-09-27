package flyinghigh.services.flights.services.database;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.domain.Route;
import flyinghigh.services.flights.repositories.AirportRepository;
import flyinghigh.services.flights.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

    private final static Airport sydney = Airport.called("Sydney").inCountry("Australia").withCode("SYD");
    private final static Airport melbourne = Airport.called("Melbourne").inCountry("Australia").withCode("MEL");
    private final static Airport brisbane = Airport.called("Brisbane").inCountry("Australia").withCode("BNE");
    private final static Airport perth = Airport.called("Perth").inCountry("Australia").withCode("PER");
    private final static Airport sanfrancisco = Airport.called("San Francisco").inCountry("USA").withCode("SFO");
    private final static Airport losangeles = Airport.called("Los Angeles").inCountry("USA").withCode("LAX");
    private final static Airport auckland = Airport.called("Auckland").inCountry("New Zealand").withCode("AKL");
    private final static Airport wellington = Airport.called("Wellington").inCountry("New Zealand").withCode("WLG");
    private final static Airport christchurch = Airport.called("Christchurch").inCountry("New Zealand").withCode("CHC");

    private final static List<Airport> DEFAULT_AIRPORTS = ImmutableList.of(
            sydney, melbourne, brisbane, perth, auckland, wellington, christchurch, sanfrancisco, losangeles
    );


    private static final List<Route> DEFAULT_ROUTES = ImmutableList.of(
            Route.from(sydney).to(melbourne).withDistanceOf(850).km(),
            Route.from(sydney).to(brisbane).withDistanceOf(1200).km(),
            Route.from(sydney).to(perth).withDistanceOf(3000).km(),
            Route.from(sydney).to(auckland).withDistanceOf(1800).km(),
            Route.from(sydney).to(wellington).withDistanceOf(2000).km(),
            Route.from(sydney).to(christchurch).withDistanceOf(2500).km(),
            Route.from(sydney).to(sanfrancisco).withDistanceOf(6500).km(),
            Route.from(sydney).to(losangeles).withDistanceOf(6000).km(),

            Route.from(melbourne).to(sydney).withDistanceOf(850).km(),
            Route.from(melbourne).to(brisbane).withDistanceOf(2000).km(),
            Route.from(melbourne).to(perth).withDistanceOf(2700).km(),
            Route.from(melbourne).to(auckland).withDistanceOf(2500).km(),
            Route.from(melbourne).to(wellington).withDistanceOf(2200).km(),
            Route.from(melbourne).to(christchurch).withDistanceOf(2800).km(),
            Route.from(melbourne).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(melbourne).to(losangeles).withDistanceOf(6200).km(),

            Route.from(brisbane).to(sydney).withDistanceOf(850).km(),
            Route.from(brisbane).to(melbourne).withDistanceOf(2000).km(),
            Route.from(brisbane).to(perth).withDistanceOf(2700).km(),
            Route.from(brisbane).to(auckland).withDistanceOf(2500).km(),
            Route.from(brisbane).to(wellington).withDistanceOf(2200).km(),
            Route.from(brisbane).to(christchurch).withDistanceOf(2800).km(),
            Route.from(brisbane).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(brisbane).to(losangeles).withDistanceOf(6200).km(),

            Route.from(perth).to(sydney).withDistanceOf(850).km(),
            Route.from(perth).to(melbourne).withDistanceOf(2000).km(),
            Route.from(perth).to(brisbane).withDistanceOf(2700).km(),
            Route.from(perth).to(auckland).withDistanceOf(2500).km(),
            Route.from(perth).to(wellington).withDistanceOf(2200).km(),
            Route.from(perth).to(christchurch).withDistanceOf(2800).km(),
            Route.from(perth).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(perth).to(losangeles).withDistanceOf(6200).km()
            );

    private
    @Autowired
    AirportRepository airportRepository;
    private
    @Autowired
    RouteRepository routeRepository;

    @Override
    public void initializeReferenceData() {
        airportRepository.deleteAll();
        airportRepository.save(DEFAULT_AIRPORTS);

        routeRepository.deleteAll();
        routeRepository.save(DEFAULT_ROUTES);

    }
}
