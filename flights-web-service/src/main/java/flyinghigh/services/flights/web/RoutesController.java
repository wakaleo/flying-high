package flyinghigh.services.flights.web;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import flyinghigh.services.flights.repositories.RouteRepository;
import flyinghigh.services.flights.services.DatabaseSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoutesController {

    @Autowired private RouteRepository routeRepository;

    @Autowired
    private DatabaseSetup databaseSetup;

//    @RequestMapping("/rest/api/routes/departingFrom")
//    public List<Airport> listAirports() {
//        return routeRepository.findByDepartureCode());
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/routes/reset")
    public void initializeAccounts() {
        databaseSetup.initializeReferenceData();;
    }


}
