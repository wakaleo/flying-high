package flyinghigh.services.accounts.domain;

import org.springframework.data.annotation.Id;

import java.lang.String;

public class FrequentFlyerMember {
    @Id
    private String id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String homeAirportCode;
    private int statusPoints;
    private Status status = Status.Bronze;

    public FrequentFlyerMember() {
    }

    public FrequentFlyerMember(String id,
                               String accountNumber,
                               String firstName,
                               String lastName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = 0;
    }

    protected FrequentFlyerMember(String id,
                               String accountNumber,
                               String firstName,
                               String lastName,
                               String homeAirportCode,
                               int statusPoints,
                               Status status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAirportCode = homeAirportCode;
        this.statusPoints = statusPoints;
        this.status = status;
    }

    public FrequentFlyerMember(String accountNumber, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = 0;
    }

    public FrequentFlyerMember(String accountNumber, String firstName, String lastName, int statusPoints, String homeAirportCode) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = statusPoints;
        this.homeAirportCode = homeAirportCode;
    }

    public String getId() {
        return id;
    }

    public int getStatusPoints() {
        return statusPoints;
    }

    protected void setStatusPoints(int statusPoints) {
        this.statusPoints = statusPoints;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getHomeAirportCode() {
        return homeAirportCode;
    }

    public Status getStatus() {
        return status;
    }

    public FrequentFlyerMember withStatusPoints(int statusPoints) {
        return new FrequentFlyerMember(id, accountNumber, firstName, lastName, homeAirportCode, statusPoints, status);
    }
    public FrequentFlyerMember withStatus(Status status) {
        return new FrequentFlyerMember(id, accountNumber, firstName, lastName, homeAirportCode, statusPoints, status);
    }

    public Earner earns(int amount) {
        return new Earner(amount, this);
    }

    public static class Earner {
        private final int amount;

        private final FrequentFlyerMember account;

        public Earner(int amount, FrequentFlyerMember account) {
            this.amount = amount;
            this.account = account;
        }

        public void statusPoints() {
            account.setStatusPoints(account.getStatusPoints() + amount);
            account.setStatus(Status.statusLevelFor(account.getStatusPoints()));
        }
    }


    public static FrequentFlyerBuilder withFrequentFlyerNumber(String frequentFlyerNumber) {
        return new FrequentFlyerBuilder(frequentFlyerNumber);
    }

    public static class FrequentFlyerBuilder {

        private String frequentFlyerNumber;

        public FrequentFlyerBuilder(String frequentFlyerNumber) {
            this.frequentFlyerNumber = frequentFlyerNumber;
        }

        public FrequentFlyerMember named(String firstName, String lastName) {
            return new FrequentFlyerMember(frequentFlyerNumber, firstName, lastName);
        }
    }
}
