package flyinghigh.services.acceptancetests.stepdefs;

import flyinghigh.services.acceptancetests.rest.RestClient;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by john on 27/09/2014.
 */
public class RouteStepDefinitions {

    RestClient restClient = new RestClient();

    String departure;
    String destination;
    int calculatedPoints;

    @Given("I want to go from <departure> to <destination>")
    public void setDepartureAndDestination(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }
    @When("I calculate the number of required points")
    public void calculateRequiredPoints() {
        calculatedPoints = restClient.calculateRequiredPoints(departure, destination);
    }

    @Then("I should obtain <requiredPoints>")
    public void checkCalculatedPoints(int requiredPoints) {
        assertThat(calculatedPoints).isEqualTo(requiredPoints);
    }
}
