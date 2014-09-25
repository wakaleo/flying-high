package flyinghigh.services.accounts.web;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import flyinghigh.services.accounts.repositories.AccountRepository;
import flyinghigh.services.accounts.services.DatabaseSetup;
import groovy.transform.Immutable;
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
        return ImmutableList.of("Paris","London");
    }

}
