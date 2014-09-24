package flyinghigh.services.acceptancetests.steps;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.acceptancetests.domain.Airport;
import flyinghigh.services.acceptancetests.rest.RestClient;
import net.thucydides.core.annotations.Step;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by john on 17/09/2014.
 */
public class AirportClientSteps {

    RestClient restClient = new RestClient();

    @Step
    public List<Airport> listAllAirports(String path) {
        return restClient.findAllAirports(path);
    }
}
