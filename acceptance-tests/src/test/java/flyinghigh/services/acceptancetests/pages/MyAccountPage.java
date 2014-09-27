package flyinghigh.services.acceptancetests.pages;

import flyinghigh.services.acceptancetests.domain.Airport;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://localhost:9001/#/myaccount")
public class MyAccountPage extends PageObject {

    private int calculatedPoints;

    public void selectDepartureCity(String departure) {
        $("#departure").selectByVisibleText(departure);
    }

    public void selectDestinationCity(String destination) {
        $("#destination").selectByVisibleText(destination);
    }

    public int getCalculatedPoints() {
        return Integer.valueOf($(".requiredPoints").getText());
    }
}
