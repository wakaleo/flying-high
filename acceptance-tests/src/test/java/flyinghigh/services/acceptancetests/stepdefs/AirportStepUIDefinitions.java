package flyinghigh.services.acceptancetests.stepdefs;

import com.google.common.collect.Lists;
import flyinghigh.services.acceptancetests.domain.Airport;
import flyinghigh.services.acceptancetests.pages.HomePage;
import flyinghigh.services.acceptancetests.pages.MyAccountPage;
import flyinghigh.services.acceptancetests.rest.RestClient;
import flyinghigh.services.acceptancetests.steps.AirportClientSteps;
import flyinghigh.services.acceptancetests.steps.MyAccountUISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;

import static flyinghigh.services.acceptancetests.stepdefs.AirportTableUtils.airportNamesFrom;
import static java.util.stream.Collectors.toList;
import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by john on 17/09/2014.
 */
public class AirportStepUIDefinitions {

    RestClient restClient = new RestClient();

    @Steps
    AirportClientSteps airportClientSteps;

    @Steps
    MyAccountUISteps sarah;

    HomePage homePage;
    MyAccountPage myAccountPage;

    @When("I go to the home page")
    public void openHomePage() {
        homePage.open();
    }

    @Then("I should see the list of possibile destinations")
    public void seeListOfPossibleDestinations() {
        List<Airport> expectedAirports = restClient.findAllAirports();

        List<Airport> displayedAirports = homePage.getDisplayedAirports();

        assertThat(displayedAirports.size()).isEqualTo(expectedAirports.size());
        assertThat(displayedAirports).containsAll(expectedAirports);
    }

    @Then("the following destination airports: $airports")
    public void shouldSeeAirports(ExamplesTable airports) {
        sarah.shouldSeePossibleDestinations(airportNamesFrom(airports));
    }
}
