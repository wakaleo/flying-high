package flyinghigh.services.accounts.services;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.accounts.domain.FrequentFlyerAccount;
import flyinghigh.services.accounts.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

    private final static List<FrequentFlyerAccount> DEFAULT_ACCOUNTS = ImmutableList.of(
            new FrequentFlyerAccount("123456","Sarah-Jane","Smith",500),
            new FrequentFlyerAccount("123457","Harry","Sullivan",1000),
            new FrequentFlyerAccount("123458","Jo","Grant", 2000)
    );

    private final AccountRepository accountRepository;

    @Autowired
    public DatabaseSetupImpl(AccountRepository airportRepository) {
        this.accountRepository = airportRepository;
    }

    @Override
    public void initializeAccounts() {
        accountRepository.deleteAll();
        accountRepository.save(DEFAULT_ACCOUNTS);
    }
}
