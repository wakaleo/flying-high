package flyinghigh.services.flights;

import flyinghigh.services.flights.domain.Airport;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import org.junit.runner.RunWith;

import java.util.Stack;

import static com.insightfullogic.lambdabehave.Suite.describe;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JunitSuiteRunner.class)
public class CreatingAnAirportSpecification {{

        Airport airport = Airport.called("Sydney").inCountry("Australia").withCode("SYD");

        describe("an airport", it -> {

            it.should("be created with the correct values", expect -> {
                expect.that(airport).hasProperty("name", equalTo("Sydney"));
                expect.that(airport).hasProperty("code", equalTo("SYD"));
                expect.that(airport).hasProperty("country", equalTo("Australia"));
            });
        });


}}
