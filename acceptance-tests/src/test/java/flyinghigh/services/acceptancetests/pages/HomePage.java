package flyinghigh.services.acceptancetests.pages;

import flyinghigh.services.acceptancetests.domain.Airport;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://localhost:9001/#/home")
public class HomePage extends PageObject {
    public List<Airport> getDisplayedAirports() {
        return findAll(".airport")
                .stream()
                .map(DisplayedAirport::fromWebElement)
                .collect(Collectors.toList());
    }
}
