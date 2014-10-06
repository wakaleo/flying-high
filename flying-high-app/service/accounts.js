angular.module('flying-high-app')
  .factory("Account", function ($resource, ACCOUNTS_WEB_SERVICE_URL) {
    console.log('WEB SERVICE AT ' + ACCOUNTS_WEB_SERVICE_URL);
    return $resource(ACCOUNTS_WEB_SERVICE_URL + "/rest/api/accounts/:id");
  })
  .service('destinationService', function($http, ACCOUNTS_WEB_SERVICE_URL) {
  this.getPossibleDestinations = function(id) {
    return $http.get(ACCOUNTS_WEB_SERVICE_URL + '/rest/api/accounts/' + id + '/possibleDestinations');
  };
});

