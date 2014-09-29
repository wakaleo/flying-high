package flyinghigh.services.acceptancetests.steps;

import flyinghigh.services.acceptancetests.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;

import static org.fest.assertions.api.Assertions.assertThat;

public class MyAccountUISteps {

    MyAccountPage myAccountPage;

    @Step
    public void openAccountPage() {
        myAccountPage.open();
        myAccountPage.waitForDestionionList();
    }

    @Step
    public int calculatePointsNeededBetween(String departure, String destination) {
        myAccountPage.selectDepartureCity(departure);
        myAccountPage.selectDestinationCity(destination);
        return myAccountPage.getCalculatedPoints();
    }

    @Step
    public void shouldSeeAccountBalanceOf(int expectedPoints) {
        assertThat(myAccountPage.getPointBalance()).isEqualTo(expectedPoints);
    }


}
