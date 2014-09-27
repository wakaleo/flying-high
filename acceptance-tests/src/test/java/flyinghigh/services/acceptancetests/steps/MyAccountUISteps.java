package flyinghigh.services.acceptancetests.steps;

import flyinghigh.services.acceptancetests.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;

public class MyAccountUISteps {

    MyAccountPage myAccountPage;

    @Step
    public void openAccountPage() {
        myAccountPage.open();
    }

    @Step
    public int calculatePointsNeededBetween(String departure, String destination) {
        myAccountPage.selectDepartureCity(departure);
        myAccountPage.selectDestinationCity(destination);
        return myAccountPage.getCalculatedPoints();
    }
}
