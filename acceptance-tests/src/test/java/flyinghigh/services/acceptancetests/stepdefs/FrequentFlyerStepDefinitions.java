package flyinghigh.services.acceptancetests.stepdefs;

import flyinghigh.services.acceptancetests.domain.FrequentFlyer;
import flyinghigh.services.acceptancetests.rest.RestClient;
import flyinghigh.services.acceptancetests.steps.MyAccountUISteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.net.URISyntaxException;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by john on 24/09/2014.
 */
public class FrequentFlyerStepDefinitions {

    @Steps
    RestClient restClient;

    @Steps
    MyAccountUISteps sarah;

    @Given("$frequentFlyer is a Frequent Flyer member")
    public void giveSarahSomePoints(FrequentFlyer frequentFlyer) {}

    @Pending
    @When("she views her account details")
    public void viewAccountDetails() {
//  TODO
//        sarah.openAccountPage();
    }


}
