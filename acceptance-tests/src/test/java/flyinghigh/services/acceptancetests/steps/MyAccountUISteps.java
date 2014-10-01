package flyinghigh.services.acceptancetests.steps;

import flyinghigh.services.acceptancetests.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class MyAccountUISteps {


    @Step
    public void openAccountPage() {
        myAccountPage.open();
        myAccountPage.waitForFieldsToLoad();
    }

    MyAccountPage myAccountPage;

    @Step
    public int calculatePointsNeededBetween(String departure,
                                            String destination) {
        myAccountPage.selectDepartureCity(departure);
        myAccountPage.selectDestinationCity(destination);
        myAccountPage.waitForCalulationResult();
        return myAccountPage.getCalculatedPoints();
    }

    @Step
    public void shouldSeeAccountBalanceOf(int expectedPoints) {
    // TODO
    //    assertThat(myAccountPage.getPointBalance()).isEqualTo(expectedPoints);
    }

    @Step
    public void shouldSeeHomeCity(String expectedHomeCity) {
    //  TODO
    //    assertThat(myAccountPage.getHomeCity()).isEqualTo(expectedHomeCity);
    }

    @Step
    public void shouldSeePossibleDestinations(List<String> expectedAirports) {
    // TODO
    //    assertThat(myAccountPage.getPossibleDestinations()).containsAll(expectedAirports);
    }
}
