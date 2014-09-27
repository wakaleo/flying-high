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

    public Airport(String id, String country, String name, String code) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.code = code;
    }

    public Airport(String country, String name, String code) {
        this.country = country;
        this.name = name;
        this.code = code;
    }

    public static AirportBuilder called(String name) {
        return new AirportBuilder(name);
    }



    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        if (code != null ? !code.equals(airport.code) : airport.code != null) return false;
        if (country != null ? !country.equals(airport.country) : airport.country != null) return false;
        if (name != null ? !name.equals(airport.name) : airport.name != null) return false;
        if ((id != null) && (airport.id != null) && (id != airport.id)) return false;

        return true;
    }

    @Override
    public String toString() {
        return name + "(" + code + ")";
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public static class AirportBuilder {
        public String name;

        public AirportBuilder(String name) {
            this.name = name;
        }

        public FinalizedAirportBuilder inCountry(String country) {
            return new FinalizedAirportBuilder(name, country);
        }


    }

    public static class FinalizedAirportBuilder {
        public String name;
        public String country;

        public FinalizedAirportBuilder(String name, String country) {
            this.name = name;
            this.country = country;
        }


        public Airport withCode(String code) {
            return new Airport(country, name, code);
        }
    }
}
