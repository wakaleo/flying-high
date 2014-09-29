package flyinghigh.services.flights.domain

import flyinghigh.services.flights.repositories.RouteRepository
import flyinghigh.services.flights.services.points.NoSuchRouteException
import flyinghigh.services.flights.services.points.PointsCalculator
import spock.lang.Specification

class WhenCalculatingRequiredPoints extends Specification {

    def routeRepository = Mock(RouteRepository);

    def sydney = new Airport("Australia","Sydney","SYD")
    def melbourne = new Airport("Australia","Melbourne","MEL")

    def DISTANCE = 1000
    def REQUIRED_POINTS = DISTANCE * 2

    def "Required points should be calculated based on route distance"() {
        given:
            routeRepository.findByDepartureCodeAndDestinationCode("SYD","MEL") >>
                    [Route.from(sydney).to(melbourne).withDistanceOf(DISTANCE).km()]

            def pointsCalculator = new PointsCalculator(routeRepository)
        when:
            int calculatedPoints = pointsCalculator.calculatePointsRequiredBetween("SYD", "MEL");
        then:
            calculatedPoints == REQUIRED_POINTS
    }

    def "Required points should be calculated in both directions"() {
        given:
            routeRepository.findByDepartureCodeAndDestinationCode("SYD","MEL") >> []
            routeRepository.findByDepartureCodeAndDestinationCode("MEL","SYD") >>
                    [Route.from(sydney).to(melbourne).withDistanceOf(DISTANCE).km()]

            def pointsCalculator = new PointsCalculator(routeRepository)
        when:
            int calculatedPoints = pointsCalculator.calculatePointsRequiredBetween("SYD", "MEL");
        then:
            calculatedPoints == REQUIRED_POINTS
    }

    def "Should throw NoSuchRouteException if no routes are available"() {
        given:
            routeRepository.findByDepartureCodeAndDestinationCode("MEL","SYD") >> []
            routeRepository.findByDepartureCodeAndDestinationCode("SYD","MEL") >> []
            def pointsCalculator = new PointsCalculator(routeRepository)
        when:
            pointsCalculator.calculatePointsRequiredBetween("SYD", "MEL");
        then:
            thrown(NoSuchRouteException)
    }
}