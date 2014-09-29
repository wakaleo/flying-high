package flyinghigh.services.flights;

import com.google.common.collect.ImmutableList;
import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import flyinghigh.services.flights.domain.Airport;
import flyinghigh.services.flights.domain.Route;
import flyinghigh.services.flights.repositories.RouteRepository;
import flyinghigh.services.flights.services.points.PointsCalculator;
import org.junit.runner.RunWith;

import java.util.List;

import static com.insightfullogic.lambdabehave.Suite.describe;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JunitSuiteRunner.class)
public class CalculatingEarnedPointsSpecification {
    {

        Airport sydney = new Airport("Australia", "Sydney", "SYD");
        Airport melbourne = new Airport("Australia", "Melbourne", "MEL");

        RouteRepository routeRepository = mock(RouteRepository.class);
        PointsCalculator pointsCalculator = new PointsCalculator(routeRepository);

        describe("calcuating points earned for a given route", it -> {

            it.uses(6000, 12000)
                    .and(5000, 10000)
                    .toShow("2 points should be earned per km travelled",
                            (expect, distance, expectedPoints) -> {
                                List<Route> routes = ImmutableList.of(Route.from(sydney)
                                        .to(melbourne)
                                        .withDistanceOf(distance).km());
                                when(routeRepository.findByDepartureCodeAndDestinationCode("SYD", "MEL"))
                                        .thenReturn(routes);

                                int calculatedPoints
                                        = pointsCalculator.calculatePointsRequiredBetween("SYD", "MEL");

                                expect.that(calculatedPoints).isEqualTo(expectedPoints);
                            });
        });
    }


}
