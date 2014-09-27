package flyinghigh.services.accounts.web;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import flyinghigh.services.accounts.repositories.AccountRepository;
import flyinghigh.services.accounts.services.database.DatabaseSetup;
import flyinghigh.services.accounts.services.destinations.DestinationsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/accounts")
public class AccountsController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private DestinationsCalculatorService destinationsCalculatorService;

    @RequestMapping(method = RequestMethod.GET, value = "/{number}")
    public FrequentFlyerAccount viewAccount(@PathVariable String number) {
        return accountRepository.findByAccountNumber(number);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<FrequentFlyerAccount> listAllAccounts() {
        return accountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reset")
    public void initializeAccounts() {
        databaseSetup.initializeAccounts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{number}/possibleDestinations")
    public List<String> findPossibleDestinations(@PathVariable String number) {
        FrequentFlyerAccount currentAccount = accountRepository.findByAccountNumber(number);
        return destinationsCalculatorService.findPossibleDestinations(currentAccount.getHomeAirportCode(), currentAccount.getStatusPoints());
    }

}
