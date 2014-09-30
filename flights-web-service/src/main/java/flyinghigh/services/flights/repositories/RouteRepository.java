package flyinghigh.services.flights.repositories;

import flyinghigh.services.flights.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "routes", path = "routes")
public interface RouteRepository extends MongoRepository<Route, String> {
    List<Route> findByDepartureCode(@Param("departureCode") String departureCode);
    List<Route> findByDestinationCode(@Param("destinationCode") String destinationCode);
    List<Route> findByDepartureCodeAndDestinationCode(@Param("departureCode") String departureCode,
                                                      @Param("destinationCode") String destinationCode);
}