package flyinghigh.services.flights;

import flyinghigh.services.accounts.AccountsApp;
import flyinghigh.services.accounts.domain.FrequentFlyerMember;
import flyinghigh.services.accounts.domain.Status;
import flyinghigh.services.accounts.repositories.AccountRepository;
import flyinghigh.services.accounts.services.database.DatabaseSetup;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
        FrequentFlyerMember account = accountRepository.findByAccountNumber("123456");
        assertThat(account.getFirstName()).isEqualTo("Sarah-Jane");
    }

    @Test
    public void should_list_all_known_accounts() {
        List<FrequentFlyerMember> account = accountRepository.findAll();
        assertThat(account).isNotEmpty();
    }

    @Test
    public void should_read_account_details_via_the_web_service() {
        String url = getResultUrl(restTemplate.getForObject(baseUrl + "/accounts/search/findByAccountNumber?number={number}", JSONObject.class, "123456"));
        FrequentFlyerMember member = restTemplate.getForObject(url, FrequentFlyerMember.class);

        assertThat(member.getFirstName()).isEqualTo("Sarah-Jane");
        assertThat(member.getStatus()).isEqualTo(Status.Silver);
    }

    private String getResultUrl(JSONObject result) {
        return ((JSONObject)((JSONArray)result.get("links")).get(0)).get("href").toString();
    }

}
