package flyinghigh.services.acceptancetests.pages;

import flyinghigh.services.acceptancetests.domain.Airport;
import javafx.beans.binding.MapExpression;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@DefaultUrl("http://localhost:9001/#/myaccount")
public class MyAccountPage extends PageObject {

    public void selectDepartureCity(String departure) {
        $("#departure").selectByVisibleText(departure);
    }

    public void selectDestinationCity(String destination) {
        $("#destination").selectByVisibleText(destination);
    }

    public int getCalculatedPoints() {
        return Integer.valueOf($(".requiredPoints").getText());
    }

    public int getPointBalance() {
        return Integer.valueOf($(".status-points-balance").getText());
    }

    public void waitForFieldsToLoad() {
        waitFor("#destination option:nth-child(2)");
        waitFor(250).milliseconds();
    }

    public void waitForCalulationResult() {
        waitFor(".requiredPoints");
        waitFor(250).milliseconds();
    }

    public String getHomeCity() {
        return $("#home-city").getText();
    }

    public List<String> getPossibleDestinations() {
        return findAll(".possible-destination-name")
               .stream()
               .map(WebElement::getText)
               .collect(toList());
    }
}
