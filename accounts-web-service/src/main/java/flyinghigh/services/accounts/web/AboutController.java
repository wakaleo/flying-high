package flyinghigh.services.accounts.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@RestController
public class AboutController {

    @RequestMapping("/about")
    public String displayVersionDetails() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/application.properties"));
        String version = properties.getProperty("application.version");
        StringBuilder about = new StringBuilder();
        about.append("ACCOUNTS WEB SERVICE VERSION ");
        about.append(version);

        return about.toString();
    }

}
