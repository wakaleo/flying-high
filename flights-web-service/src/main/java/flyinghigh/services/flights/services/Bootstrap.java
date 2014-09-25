package flyinghigh.services.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private @Autowired DatabaseSetup databaseSetup;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        databaseSetup.initializeReferenceData();
    }
}
