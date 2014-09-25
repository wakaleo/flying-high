package flyinghigh.services.accounts.domain;

import org.springframework.data.annotation.Id;

import java.lang.String;

public class FrequentFlyerAccount {
    @Id
    private String id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private int statusPoints;

    public FrequentFlyerAccount() {
    }

    public FrequentFlyerAccount(String id, String accountNumber, String firstName, String lastName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = 0;
    }

    public FrequentFlyerAccount(String accountNumber, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = 0;
    }

    public FrequentFlyerAccount(String accountNumber, String firstName, String lastName, int statusPoints) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusPoints = statusPoints;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Earner earns(int amount) {
        return new Earner(amount, this);
    }

    public static class Earner {
        private final int amount;

        private final FrequentFlyerAccount account;

        public Earner(int amount, FrequentFlyerAccount account) {
            this.amount = amount;
            this.account = account;
        }

        public void statusPoints() {
            account.setStatusPoints(account.getStatusPoints() + amount);
        }
    }
}
