package flyinghigh.services.acceptancetests.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import flyinghigh.services.acceptancetests.domain.Airport;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by john on 17/09/2014.
 */
public class AirportClientSteps {

    private RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders APPLICATION_JSON_HEADER = new HttpHeaders();
    static {
        APPLICATION_JSON_HEADER.setContentType(MediaType.APPLICATION_JSON);
    }


    EnvironmentVariables environmentVariables;

    public AirportClientSteps() {
        environmentVariables = new SystemEnvironmentVariables();
    }

    public String getBaseFlightUrl() {
        String environment = environmentVariables.getProperty("webservice.environment","local");
        if (environment.equals("local")) {
            return "http://localhost:8090/";
        } else {
            return "http://" + environment + "-" + "flights.cfapps.io";
        }
    }

    @Step
    public List<Airport> listAllAirports(String path) {
        return ImmutableList.copyOf(restTemplate.getForEntity(getBaseFlightUrl() + path, Airport[].class).getBody());
    }
}
