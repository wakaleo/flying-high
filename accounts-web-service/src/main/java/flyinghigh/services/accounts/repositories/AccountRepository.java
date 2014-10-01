package flyinghigh.services.accounts.repositories;

import flyinghigh.services.accounts.domain.FrequentFlyerMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends MongoRepository<FrequentFlyerMember, String> {
    FrequentFlyerMember findByAccountNumber(@Param("number") String number);
}