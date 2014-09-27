package flyinghigh.services.flights.services.points;

/**
 * Created by john on 27/09/2014.
 */
public class NoSuchRouteException extends Exception {
    public NoSuchRouteException(String message) {
        super(message);
    }
}
