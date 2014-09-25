package flyinghigh.services.flights;

import flyinghigh.services.accounts.AccountsApp;
import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import flyinghigh.services.accounts.repositories.AccountRepository;
import flyinghigh.services.accounts.services.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsApp.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class LookingUpAccountsIT {

    @Autowired
    private EmbeddedWebApplicationContext server;

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private AccountRepository accountRepository;

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl;

    @Before
    public void configureBaseUrl() {
        baseUrl = "http://localhost:" + port;
        restTemplate = new RestTemplate();
        databaseSetup.initializeAccounts();
    }

    @Test
    public void should_find_a_user_with_a_given_account_number() {
        FrequentFlyerAccount account = accountRepository.findByAccountNumber("123456");
        assertThat(account.getFirstName()).isEqualTo("Sarah-Jane");
    }

    @Test
    public void should_list_all_known_accounts() {
        List<FrequentFlyerAccount> account = accountRepository.findAll();
        assertThat(account).isNotEmpty();
    }

}
