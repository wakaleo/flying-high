package flyinghigh.services.acceptancetests.domain;

/**
 * Created by john on 27/09/2014.
 */
public enum FrequentFlyer {
    Sarah("123456");

    private final String number;

    FrequentFlyer(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
