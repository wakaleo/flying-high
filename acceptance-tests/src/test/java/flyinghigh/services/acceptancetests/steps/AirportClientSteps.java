package flyinghigh.services.acceptancetests.steps;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.acceptancetests.domain.Airport;
import net.thucydides.core.annotations.Step;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

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

    public String getBaseFlightUrl() {
        String environment =  System.getProperty("webservice.environment","local");
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
