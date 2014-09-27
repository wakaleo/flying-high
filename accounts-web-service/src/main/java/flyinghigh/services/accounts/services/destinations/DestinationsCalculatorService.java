package flyinghigh.services.accounts.services.destinations;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.flights.domain.Route;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinationsCalculatorService {
    public List<String> findPossibleDestinations(String homeAirportCode, int statusPoints) {
        return ImmutableList.of("Melbourne", "Brisbane");
    }
}
