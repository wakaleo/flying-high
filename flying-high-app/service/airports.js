angular.module('flying-high-app')
  .factory("Airport", function ($resource, FLIGHTS_WEB_SERVICE_URL) {
    console.log('WEB SERVICE AT ' + FLIGHTS_WEB_SERVICE_URL);
    return $resource(FLIGHTS_WEB_SERVICE_URL + "/rest/api/airports");
  })
  .service('airportService', function ($http, FLIGHTS_WEB_SERVICE_URL) {
    this.allAirports = function () {
      return $http.get(FLIGHTS_WEB_SERVICE_URL + '/rest/api/airports');
    };
    this.airportWithCode = function (code) {
      return $http.get(FLIGHTS_WEB_SERVICE_URL + '/rest/api/airports/search/findByCode?code=' + code);
    };
    this.airportsWithFlightsFrom = function (departureAirport) {
      return $http.get(FLIGHTS_WEB_SERVICE_URL + '/rest/api/routes/from?departureCode=' + departureAirport);
    };
    this.airportsWithFlightsTo = function (destinationAirport) {
      return $http.get(FLIGHTS_WEB_SERVICE_URL + '/rest/api/routes/to?destinationCode=' + destinationAirport);
    };
  })
  .service('calculatePointsService', function ($http, FLIGHTS_WEB_SERVICE_URL) {
    this.calculateRequiredPoints = function (departureCode, destinationCode) {
      return $http.get(FLIGHTS_WEB_SERVICE_URL + '/rest/api/routes/calculatePoints?departureCode=' + departureCode + '&destinationCode='+destinationCode);
    };
  });

