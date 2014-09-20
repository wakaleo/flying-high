package flyinghigh.services.flights.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.util.StringUtils;

import java.net.UnknownHostException;
import java.util.Optional;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration {

    private @Autowired Environment environment;

    public @Bean MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient();
    }

    public @Bean MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost(environment.getProperty("mongodb.host", "localhost"));
        return mongo;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        String database = environment.getProperty("mongodb.database","flyinghigh");

        Optional<UserCredentials> optionalCredentials = findCredentials();
        return new SimpleMongoDbFactory(mongoClient(), database, optionalCredentials.orElse(null));
    }

    private Optional<UserCredentials> findCredentials() {
        String username = environment.getProperty("mongodb.username");
        String password = environment.getProperty("mongodb.password");
        if (!StringUtils.isEmpty(username)) {
            return Optional.of(new UserCredentials(username, password));
        } else {
            return Optional.empty();
        }
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

    public @Bean Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

        Resource sourceData = new ClassPathResource("initial-data.json");

        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        // Set a custom ObjectMapper if Jackson customization is needed
        //  factory.setObjectMapper(…);
        factory.setResources(new Resource[] { sourceData });
        return factory;
    }
}
