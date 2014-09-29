package flyinghigh.services.acceptancetests.stepdefs;

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

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by john on 17/09/2014.
 */
public class MyAccountStepUIDefinitions {

    @Steps
    MyAccountUISteps myAccountSteps;

    @Given("I am on the My Account page")
    public void openMyAccountPage() {
        myAccountSteps.openAccountPage();
    }

    int calculatedPoints;

    @When("I calculate the points needed to go from <departure> to <destination>")
    public void calculatePointsNeeded(String departure, String destination) {
        calculatedPoints = myAccountSteps.calculatePointsNeededBetween(departure,
                                                                       destination);
    }

    @Then("I should see <requiredPoints> points")
    public void shouldSeeRequiredPoints(int requiredPoints) {
        assertThat(calculatedPoints).isEqualTo(requiredPoints);
    }


}
