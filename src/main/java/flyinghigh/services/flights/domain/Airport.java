package flyinghigh.services.flights.domain;

import org.springframework.data.annotation.Id;

public class Airport {
    @Id
    private String id;

    private String code;
    private String name;
    private String country;

    public Airport() {
    }

    public Airport(String country, String name, String code) {
        this.country = country;
        this.name = name;
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
