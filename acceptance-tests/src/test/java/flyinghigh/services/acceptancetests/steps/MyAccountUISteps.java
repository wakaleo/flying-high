package flyinghigh.services.acceptancetests.steps;

import flyinghigh.services.acceptancetests.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;

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
        assertThat(myAccountPage.getPointBalance()).isEqualTo(expectedPoints);
    }


}
