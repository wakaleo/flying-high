package flyinghigh.services.flights.web;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReferenceDataController {

    private @Autowired AirportRepository airportRepository;

    @RequestMapping("/reference/airports")
    public List<Airport> listAirports() {
        return airportRepository.findAll(new Sort("name"));
    }

}
