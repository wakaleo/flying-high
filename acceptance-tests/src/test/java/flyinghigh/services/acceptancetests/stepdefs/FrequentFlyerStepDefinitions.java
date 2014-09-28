package flyinghigh.services.acceptancetests.stepdefs;

import flyinghigh.services.acceptancetests.domain.FrequentFlyer;
import flyinghigh.services.acceptancetests.rest.RestClient;
import flyinghigh.services.acceptancetests.steps.MyAccountUISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.net.URISyntaxException;

/**
 * Created by john on 24/09/2014.
 */
public class FrequentFlyerStepDefinitions {

    RestClient restClient = new RestClient();

    @Steps
    MyAccountUISteps sarah;

    @Given("I am a frequent flyer")
    public void givenAFrequentFlyer() {
    }

    @Given("$frequentFlyer is a Frequent Flyer member with $points points")
    public void giveSarahSomePoints(FrequentFlyer frequentFlyer, int points) throws URISyntaxException {
        restClient.updatePointsFor(frequentFlyer.getNumber(), points);
    }

    @When("Sarah views her account details")
    public void viewAccountDetails() {
        sarah.openAccountPage();
    }

    @Then("she should see an account balance of $expectedPoints points")
    public void shouldSeePointBalanceOf(int expectedPoints) {
        sarah.shouldSeeAccountBalanceOf(expectedPoints);
    }
}
