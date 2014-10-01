package flyinghigh.services.accounts.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Status {

    Bronze(0), Silver(300), Gold(700), Platinum(1500);

    private final int minimumPoints;

    Status(int minimumPoints) {
        this.minimumPoints = minimumPoints;
    }

    public static Status statusLevelFor(int points) {
        Optional<Status> matchingStatus =
                Arrays.asList(Status.values())
                      .stream()
                      .sorted(Status::decendingMinimumPoints)
                      .filter(status -> points >= status.getMinimumPoints())
                      .findFirst();

        return matchingStatus.orElse(Bronze);
    }

    public int getMinimumPoints() {
        return minimumPoints;
    }

    private static int decendingMinimumPoints(Status status1, Status status2) {
        return status2.getMinimumPoints() - status1.getMinimumPoints();
    }


}
