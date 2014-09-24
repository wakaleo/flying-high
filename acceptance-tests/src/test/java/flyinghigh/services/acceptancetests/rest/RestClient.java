package flyinghigh.services.acceptancetests.rest;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.acceptancetests.domain.Airport;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient {

    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseFlightUrl() {
        String environment =  System.getProperty("webservice.environment","local");
        if (environment.equals("local")) {
            return "http://localhost:8090/";
        } else {
            return "http://" + environment + "-" + "flights.cfapps.io";
        }
    }

    public List<Airport> findAllAirports() {
        return findAllAirports("/rest/api/airports");
    }


    public List<Airport> findAllAirports(String path) {
        return ImmutableList.copyOf(restTemplate.getForEntity(getBaseFlightUrl() + path, Airport[].class).getBody());
    }
}
