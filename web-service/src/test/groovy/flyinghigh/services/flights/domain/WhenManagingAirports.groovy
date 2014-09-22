package flyinghigh.services.flights.domain

import spock.lang.Specification
import flyinghigh.services.flights.domain.Airport

class WhenManagingAirports extends Specification {
    def "Airports have a name and a code"() {
        when:
            def airport = new Airport("Australia","Sydney","SYD")
        then:
            airport.name == "Sydney"
        and:
            airport.code == "SYD"
    }
}