package flyinghigh.services.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class AccountsApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AccountsApp.class);
        springApplication.run(args);
    }
}