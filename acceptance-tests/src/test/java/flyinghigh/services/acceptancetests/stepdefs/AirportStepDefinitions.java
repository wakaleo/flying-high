package flyinghigh.services.acceptancetests.stepdefs;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import flyinghigh.services.acceptancetests.domain.Airport;
import flyinghigh.services.acceptancetests.domain.FrequentFlyer;
import flyinghigh.services.acceptancetests.pages.DisplayedAirport;
import flyinghigh.services.acceptancetests.rest.RestClient;
import flyinghigh.services.acceptancetests.steps.AirportClientSteps;
import flyinghigh.services.acceptancetests.steps.MyAccountUISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.net.URISyntaxException;
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


    @Steps
    RestClient restClient;

    @Steps
    MyAccountUISteps sarah;

    @Given("I am a frequent flyer")
    public void givenAFrequentFlyer() {
    }

    @Pending
    @Given("$frequentFlyer is a Frequent Flyer member with $points points")
    public void giveSarahSomePoints(String name, int points) throws URISyntaxException {
//  TODO
//        FrequentFlyer frequentFlyer = FrequentFlyer.valueOf(name);
//        restClient.updatePointsFor(frequentFlyer.getNumber(), points);
    }


    @Pending
    @Then("she should see an account balance of $expectedPoints points")
    public void shouldSeePointBalanceOf(int expectedPoints) {
//  TODO
//        sarah.shouldSeeAccountBalanceOf(expectedPoints);
    }

    @Pending
    @Then("she should see a home city of $homeCity")
    public void shouldSeeHomeCityOf(String homeCity) {
    // TODO
    //    sarah.shouldSeeHomeCity(homeCity);
    }

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
