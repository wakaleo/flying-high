package flyinghigh.services.acceptancetests.stepdefs;

import org.jbehave.core.model.ExamplesTable;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by john on 30/09/2014.
 */
public class AirportTableUtils {
    public static List<String> airportNamesFrom(ExamplesTable airports) {
        return airports.getRows()
                .stream()
                .map(row -> row.get("airport"))
                .collect(toList());
    }
}
