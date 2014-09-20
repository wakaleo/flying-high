package flyinghigh.services.flights.web;

import flyinghigh.services.flights.services.DatabaseSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ini")
/**
 * Initialize the airport database with a list of known airports.
 */
public class DatabaseInitializationController {

    private final DatabaseSetup databaseSetup;

    @Autowired
    public DatabaseInitializationController(DatabaseSetup databaseSetup) {
        this.databaseSetup = databaseSetup;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String initializeDatabase() {

        databaseSetup.initializeAirports();

        return "{\"database-initialization\":\"OK\"}";
    }
}
