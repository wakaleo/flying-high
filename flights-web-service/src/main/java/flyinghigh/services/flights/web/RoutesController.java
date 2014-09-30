package flyinghigh.services.flights.web;

import com.google.common.collect.Lists;
import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.domain.Route;
import flyinghigh.services.flights.repositories.RouteRepository;
import flyinghigh.services.flights.services.database.DatabaseSetup;
import flyinghigh.services.flights.services.points.NoSuchRouteException;
import flyinghigh.services.flights.services.points.PointsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class RoutesController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private PointsCalculator pointsCalculator;

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/routes/reset")
    public void initializeAccounts() {
        databaseSetup.initializeReferenceData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/routes/calculatePoints")
    public int calculateRequiredPoints(@RequestParam("departureCode") String departureCode,
                                       @RequestParam("destinationCode") String destinationCode)
            throws NoSuchRouteException {

        return (departureCode.equals(destinationCode)) ?
                0 : pointsCalculator.calculatePointsRequiredBetween(departureCode, destinationCode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/routes/from")
    public List<Airport> airportsWithFlightsFrom(@RequestParam("departureCode") String departureCode)
            throws NoSuchRouteException {
        List<Airport> departs =  routeRepository.findByDepartureCode(departureCode)
                .stream()
                .map(Route::getDestination)
                .collect(toList());

        List<Airport> returns = routeRepository.findByDestinationCode(departureCode)
                .stream()
                .map(Route::getDeparture)
                .collect(toList());

        return combinationOf(departs, returns);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/routes/to")
    public List<Airport> airportsWithFlightsTo(@RequestParam("destinationCode") String destinationCode)
            throws NoSuchRouteException {
        List<Airport> departs = routeRepository.findByDestinationCode(destinationCode)
                .stream()
                .map(Route::getDeparture)
                .collect(toList());

        List<Airport> returns = routeRepository.findByDepartureCode(destinationCode)
                .stream()
                .map(Route::getDestination)
                .collect(toList());

        return combinationOf(departs, returns);

    }

    private List<Airport> combinationOf(List<Airport> departs, List<Airport> returns) {
        List<Airport> allAirports = Lists.newArrayList(departs);
        allAirports.addAll(returns);
        return allAirports.stream().distinct().collect(toList());
    }

}
