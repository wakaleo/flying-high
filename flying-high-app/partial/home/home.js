angular.module('flying-high-app')
.controller("HomeCtrl", function($scope, Airport) {
  Airport.query(function(data) {
    $scope.airports = data;
  });
});