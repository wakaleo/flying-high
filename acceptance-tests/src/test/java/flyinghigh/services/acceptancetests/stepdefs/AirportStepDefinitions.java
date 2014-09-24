package flyinghigh.services.acceptancetests.stepdefs;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import flyinghigh.services.acceptancetests.domain.Airport;
import flyinghigh.services.acceptancetests.pages.DisplayedAirport;
import flyinghigh.services.acceptancetests.steps.AirportClientSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.collect;
import static org.fest.assertions.api.Assertions.assertThat;


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
        retrievedAirports = airportClientSteps.listAllAirports("/rest/api/airports");
    }



    @Then("I should obtain at least the following: $expectedAirports")
    public void thenIShouldObtainAtLeastTheFollowing(ExamplesTable expectedAirports) {

        List<Airport> expected = Lists.newArrayList();
        for(Map<String, String> airportFields : expectedAirports.getRows()) {
            expected.add(DisplayedAirport.fromMapValues(airportFields));

        }
        assertThat(retrievedAirports).containsAll(expected);
    }



}
