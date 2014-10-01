package flyinghigh.services.flights.domain

import flyinghigh.services.accounts.domain.Status
import spock.lang.Unroll

import static flyinghigh.services.accounts.domain.Status.*
import spock.lang.Specification

class WhenUsingStatusValues extends Specification {

    @Unroll("Expect #expectedStatusLevel for #pointsEarned points earned")
    def "should find the status value achieved with a given number of points"() {
        expect:
            Status.statusLevelFor(pointsEarned) == expectedStatusLevel
        where:
            pointsEarned | expectedStatusLevel
            0            | Bronze
            299          | Bronze
            300          | Silver
            699          | Silver
            700          | Gold
            1499         | Gold
            1500         | Platinum
            1000000      | Platinum
    }
}