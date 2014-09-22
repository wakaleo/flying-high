package flyinghigh.services.flights.domain

import spock.lang.Specification

class WhenManagingAirports extends Specification {
    def "Airports have a name and a code"() {
        when:
            def airport = new Airport("Australia","Sydney","SYD")
        then:
            airport.name == "Sydney"
        and:
            airport.code == "SYD"
    }

    def "Should be able to create airports easily"() {
        when:
            def airport = Airport.called("Sydney").inCountry("Australia").withCode("SYD")
        then:
            airport.name == "Sydney"
            airport.code == "SYD"
            airport.country == "Australia"
    }
}