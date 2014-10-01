package flyinghigh.services.flights.web;

/**
 * Created by john on 30/09/2014.
 */
public class UnknownAirportException extends RuntimeException {
    public UnknownAirportException(String code) {
        super(code);
    }
}
