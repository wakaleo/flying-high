package flyinghigh.services.acceptancetests;

import net.thucydides.jbehave.ThucydidesJUnitStories;

/**
 * Created by john on 18/09/2014.
 */
public class ManagingAirports extends ThucydidesJUnitStories {

    public ManagingAirports() {
        findStoriesIn("stories/managing_airports");
    }
}
