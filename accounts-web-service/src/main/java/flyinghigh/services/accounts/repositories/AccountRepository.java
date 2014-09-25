package flyinghigh.services.accounts.repositories;

import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends MongoRepository<FrequentFlyerAccount, String> {
    FrequentFlyerAccount findByAccountNumber(@Param("number") String number);
}