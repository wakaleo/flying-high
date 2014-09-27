package flyinghigh.services.flights.web;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.RouteRepository;
import flyinghigh.services.flights.services.database.DatabaseSetup;
import flyinghigh.services.flights.services.points.NoSuchRouteException;
import flyinghigh.services.flights.services.points.PointsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                                       @RequestParam("destinationCode") String destinationCode) throws NoSuchRouteException {

        if (!departureCode.equals(destinationCode)) {
            return pointsCalculator.calculatePointsRequiredBetween(departureCode, destinationCode);
        } else {
            return 0;
        }
    }
}
