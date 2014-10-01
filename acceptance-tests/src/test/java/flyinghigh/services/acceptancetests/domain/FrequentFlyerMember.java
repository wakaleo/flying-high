package flyinghigh.services.acceptancetests.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by john on 27/09/2014.
 */
@JsonIgnoreProperties({"_links"})
public class FrequentFlyerMember {
    private String id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String homeAirportCode;
    private int statusPoints;
    private String status;

    public FrequentFlyerMember() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStatusPoints() {
        return statusPoints;
    }

    public void setStatusPoints(int statusPoints) {
        this.statusPoints = statusPoints;
    }

    public String getHomeAirportCode() {
        return homeAirportCode;
    }

    public void setHomeAirportCode(String homeAirportCode) {
        this.homeAirportCode = homeAirportCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
