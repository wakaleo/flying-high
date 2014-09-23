package flyinghigh.services.acceptancetests.domain;

/**
 * Created by john on 23/09/2014.
 */
public class Airport {
    private String id;
    private String name;
    private String code;
    private String country;

    public Airport() {
    }

    public Airport(String name, String code, String country) {
        this.name = name;
        this.code = code;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        if (code != null ? !code.equals(airport.code) : airport.code != null) return false;
        if (country != null ? !country.equals(airport.country) : airport.country != null) return false;
        if (name != null ? !name.equals(airport.name) : airport.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
