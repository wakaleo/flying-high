package flyinghigh.services.flights.services.points;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.domain.Route;
import flyinghigh.services.flights.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointsCalculator {

    private final RouteRepository routeRepository;

    private final int POINTS_PER_KM = 2;

    @Autowired
    public PointsCalculator(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public int calculatePointsRequiredBetween(String departureCode, String destinationCode) throws NoSuchRouteException {
        List<Route> routes = routeRepository.findByDepartureCodeAndDestinationCode(departureCode, destinationCode);

        if (noAvailable(routes)) {
            routes = routeRepository.findByDepartureCodeAndDestinationCode(destinationCode, departureCode);

            if (noAvailable(routes)) {
                throw new NoSuchRouteException("No route between " + departureCode + " and " + destinationCode);
            }
        }

        return routes.get(0).getDistance() * POINTS_PER_KM;
    }

    private boolean noAvailable(List<Route> routes) {
        return (routes.isEmpty());
    }


}
