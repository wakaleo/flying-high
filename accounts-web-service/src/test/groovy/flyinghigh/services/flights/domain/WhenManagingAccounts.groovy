package flyinghigh.services.flights.domain

import flyinghigh.services.accounts.domain.FrequentFlyerMember
import spock.lang.Specification

class WhenManagingAccounts extends Specification {
    def "Accounts start off with zero status points"() {
        when:
            def account = new FrequentFlyerMember("123456","Sarah-Jane","Smith")
        then:
            account.statusPoints == 0
    }

    def "Should be able to earn points"() {
        given:
            def account = new FrequentFlyerMember("123456","Sarah-Jane","Smith")
        when:
            account.earns(100).statusPoints()
        then:
            account.statusPoints == 100
    }
}