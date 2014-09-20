package flyinghigh.services.acceptancetests.steps;

import flyinghigh.services.flights.domain.Airport;
import net.thucydides.core.annotations.Step;
import org.springframework.http.*;
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

    @Step
    public List<Airport> listAllAirports(String path) {
        String baseUrl = "http://localhost:8090/";

        String response = restTemplate.getForObject(baseUrl + path, String.class);
//        ResponseEntity<Resource<List<Airport>>> responseEntity
//                 = restTemplate.exchange(baseUrl + path,
//                                         HttpMethod.GET, null,
//                                         new ParameterizedTypeReference<Resource<List<Airport>>>() {}, Collections.emptyMap());
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            Resource<List<Airport>> airports = responseEntity.getBody();
//            return airports.getContent();
//        }
        return null;

    }
}
