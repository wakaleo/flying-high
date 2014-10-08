package flyinghigh.services.acceptancetests;

import net.thucydides.jbehave.ThucydidesJUnitStories;
import net.thucydides.jbehave.ThucydidesJUnitStory;

/**
 * Created by john on 18/09/2014.
 */
public class EarningPoints extends ThucydidesJUnitStories {

    public EarningPoints() {
        findStoriesIn("stories/earning_points");
    }
}
