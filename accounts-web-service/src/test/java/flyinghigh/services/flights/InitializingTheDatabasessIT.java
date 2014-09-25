package flyinghigh.services.flights;

import flyinghigh.services.accounts.AccountsApp;
import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import flyinghigh.services.accounts.repositories.AccountRepository;
import flyinghigh.services.accounts.services.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class InitializingTheDatabasessIT {

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void should_instantiate_database_with_a_few_frequent_flyers() {
        databaseSetup.initializeAccounts();
        List<FrequentFlyerAccount> accounts = accountRepository.findAll();
        assertThat(accounts).isNotEmpty();
    }

}
