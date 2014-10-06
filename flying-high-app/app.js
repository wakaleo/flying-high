angular.module('flying-high-app', ['ui.bootstrap', 'ui.utils', 'ngRoute', 'ngResource', 'ngAnimate', 'myaccount','config']);

angular.module('flying-high-app').config(function($routeProvider) {

    $routeProvider.when('/myaccount',{templateUrl: 'partial/myaccount/myaccount.html'});
    $routeProvider.when('/home',{templateUrl: 'partial/home/home.html'});
    /* Add New Routes Above */
    $routeProvider.otherwise({redirectTo:'/home'});

});

angular.module('flying-high-app').run(function($rootScope) {

    $rootScope.safeApply = function(fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof(fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };

});
