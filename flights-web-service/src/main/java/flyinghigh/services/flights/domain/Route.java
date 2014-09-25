package flyinghigh.services.flights.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by john on 26/09/2014.
 */
public class Route {
    @Id
    String id;
    Airport departure;
    Airport destination;
    int distance;


    public Route() {}

    public Route(String id, Airport departure, Airport destination, int distance) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
    }

    public Route(Airport departure, Airport destination, int distance) {
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getDeparture() {
        return departure;
    }

    public String getId() {
        return id;
    }

    public static RouteBuilder from(Airport departure) {
        return new RouteBuilder(departure);
    }

    public static class RouteBuilder {
        Airport departure;
        Airport destination;
        int distance;

        public RouteBuilder(Airport departure) {
            this.departure = departure;
        }

        public RouteBuilder to(Airport destination) {
            this.destination = destination;
            return this;
        }

        public RouteBuilder withDistanceOf(int distance) {
            this.distance = distance;
            return this;
        }

        public Route km() {
            return new Route(departure, destination, distance);
        }
    }
}
