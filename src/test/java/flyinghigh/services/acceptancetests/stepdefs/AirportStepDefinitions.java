package flyinghigh.services.acceptancetests.stepdefs;

import flyinghigh.services.acceptancetests.steps.AirportClientSteps;
import flyinghigh.services.flights.domain.Airport;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;

/**
 * Created by john on 17/09/2014.
 */
public class AirportStepDefinitions {

    @Steps
    AirportClientSteps airportClientSteps;

    @Given("I need to know what cities I can fly to")
    public void givenINeedToKnowWhatCitiesICanFlyTo() {
    }

    List<Airport> retrievedAirports;

    @When("I ask for a list of airports")
    public void whenIAskForAListOfAirports() {
        retrievedAirports = airportClientSteps.listAllAirports("/airports");
    }

    @Then("I should obtain at least the following: $expectedAirports")
    public void thenIShouldObtainAtLeastTheFollowing(ExamplesTable expectedAirports) {
        // PENDING
    }
}
