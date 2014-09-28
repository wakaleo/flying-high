package flyinghigh.services.acceptancetests;

import net.thucydides.jbehave.ThucydidesJUnitStories;

/**
 * Created by john on 18/09/2014.
 */
public class SpendingPoints extends ThucydidesJUnitStories {

    public SpendingPoints() {
        this.findStoriesIn("stories/spending_points");
    }
}
