package flyinghigh.services.accounts.services.database;

import com.google.common.collect.ImmutableList;
import flyinghigh.services.accounts.domain.FrequentFlyerMember;
import flyinghigh.services.accounts.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

    private final static List<FrequentFlyerMember> DEFAULT_ACCOUNTS = ImmutableList.of(
            new FrequentFlyerMember("123456","Sarah-Jane","Smith",500,"SYD"),
            new FrequentFlyerMember("123457","Harry","Sullivan",1000,"SYD"),
            new FrequentFlyerMember("123458","Jo","Grant", 2000,"SYD")
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
