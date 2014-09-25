package flyinghigh.services.flights.domain

import spock.lang.Specification

class WhenDefiningRoutes extends Specification {
    def "A route goes between two airports and has a distance"() {
        given:
            def sydney = new Airport("Australia","Sydney","SYD")
            def melbourne = new Airport("Australia","Melbourne","MEL")
        when:
            def route = Route.from(sydney).to(melbourne).withDistanceOf(850).km();
        then:
            route.departure == sydney
            route.destination == melbourne
            route.distance == 850
    }
}