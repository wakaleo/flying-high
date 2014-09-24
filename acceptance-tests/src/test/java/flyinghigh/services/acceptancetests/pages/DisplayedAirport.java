package flyinghigh.services.acceptancetests.pages;

import flyinghigh.services.acceptancetests.domain.Airport;
import net.thucydides.core.pages.WebElementFacade;

import java.util.Map;

/**
 * Created by john on 24/09/2014.
 */
public class DisplayedAirport {
    public static Airport fromWebElement(final WebElementFacade airportElement) {
        return new Airport(airportElement.findBy(".airport-name").getText(),
                           airportElement.findBy(".airport-code").getText(),
                           airportElement.findBy(".airport-country").getText());
    }

    public static Airport fromMapValues(final Map<String, String> airportFields) {
        return new Airport(airportFields.get("name"),
                           airportFields.get("code"),
                           airportFields.get("country"));
    }
}
