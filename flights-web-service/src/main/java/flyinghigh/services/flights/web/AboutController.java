package flyinghigh.services.flights.web;

import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@RestController
public class AboutController {

    @RequestMapping("/about")
    public String displayVersionDetails() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/application.properties"));
        String version = properties.getProperty("application.version");
        StringBuilder about = new StringBuilder();
        about.append("FLIGHTS WEB SERVICE VERSION ");
        about.append(version);

        return about.toString();
    }

}
