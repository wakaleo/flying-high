angular.module('flying-high-app')
  .controller('MyAccountCtrl', function ($scope, Account, airportService, destinationService) {
    var currentUser = 123456;
    Account.get({ id: currentUser }, function (accountDetails) {
      $scope.account = accountDetails;

      airportService.airportWithCode($scope.account.homeAirportCode).success(function(data) {
        $scope.homeAirport = data;

        airportService.airportsWithFlightsFrom($scope.homeAirport.code).success(function (data) {
          $scope.possibleDestinations = data;
        });
      });
    });
  })
  .controller('PointsCalculatorCtrl', function ($scope, airportService, calculatePointsService) {
    var currentUser = 123456;

    airportService.allAirports().success(function (data) {
      $scope.departureAirports = data;
      $scope.destinationAirports = data;
      $scope.requiredPoints = 0;
    });

    $scope.calculatePoints = function () {
      if ($scope.selectedDeparture && $scope.selectedDestination) {
        calculatePointsService
          .calculateRequiredPoints($scope.selectedDeparture.code, $scope.selectedDestination.code)
          .success(function (data) {
            $scope.requiredPoints = data;
            $scope.servicedRoute = true;
          }).
          error(function(data, status, headers, config) {
            $scope.servicedRoute = false;
          });
      }
    };
    $scope.resetAirports = function () {
      $scope.selectedDeparture = null;
      $scope.selectedDestination = null;
    };
  });
