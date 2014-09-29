package flyinghigh.services.acceptancetests.rest;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.acceptancetests.domain.Airport;
import flyinghigh.services.acceptancetests.domain.FrequentFlyerMember;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.thucydides.core.annotations.Step;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class RestClient {

    private RestTemplate restTemplate = new RestTemplate();

    public String getBaseFlightUrl() {
        String environment =  "dev";//System.getProperty("webservice.environment","local");
        if (environment.equals("local")) {
            return "http://localhost:8090/";
        } else {
            return "http://" + environment + "-" + "flights.cfapps.io";
        }
    }

    public String getBaseAccountUrl() {
        String environment =  System.getProperty("webservice.environment","local");
        if (environment.equals("local")) {
            return "http://localhost:8091/";
        } else {
            return "http://" + environment + "-" + "accounts.cfapps.io";
        }
    }

    @Step
    public List<Airport> findAllAirports() {
        return findAllAirports("/rest/api/airports");
    }


    @Step
    public List<Airport> findAllAirports(String path) {
        return ImmutableList.copyOf(restTemplate.getForEntity(getBaseFlightUrl() + path, Airport[].class).getBody());
    }


    @Step
    public int calculateRequiredPoints(String departureCode, String destinationCode) {
        String points = restTemplate.getForObject(getBaseFlightUrl() + "/rest/api/routes/calculatePoints?departureCode={departure}&destinationCode={destination}", String.class,departureCode,destinationCode);
        return Integer.valueOf(points);
    }

    @Step
    public void updatePointsFor(String number, int points) throws URISyntaxException {
        String url = getResultUrl(restTemplate.getForObject(getBaseAccountUrl() + "/accounts/search/findByAccountNumber?number={number}", JSONObject.class, number));
        FrequentFlyerMember member = restTemplate.getForObject(url, FrequentFlyerMember.class);
        member.setStatusPoints(points);
        restTemplate.put(new URI(url), member);
    }

    private String getResultUrl(JSONObject result) {
        return ((JSONObject)((JSONArray)result.get("links")).get(0)).get("href").toString();
    }
}
