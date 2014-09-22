package flyinghigh.services.flights.repositories;

import flyinghigh.services.flights.domain.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends MongoRepository<Airport, String> {
    List<Airport> findByName(@Param("name") String name);
}