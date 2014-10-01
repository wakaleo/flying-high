package flyinghigh.services.flights.web;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import flyinghigh.services.flights.services.database.DatabaseSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportsController {

    @Autowired private AirportRepository airportRepository;

    @Autowired
    private DatabaseSetup databaseSetup;

    @RequestMapping("/rest/api/airports")
    public List<Airport> listAirports() {
        return airportRepository.findAll(new Sort("name"));
    }

    @RequestMapping("/rest/api/airports/search/findByCode")
    public Airport findByCode(@RequestParam("code") String code) {
        List<Airport> matchingAirports = airportRepository.findByCode(code);
        if (matchingAirports.isEmpty()) {
            throw new UnknownAirportException(code);
        }
        return matchingAirports.get(0);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/airports/reset")
    public void initializeAccounts() {
        databaseSetup.initializeReferenceData();;
    }


}
