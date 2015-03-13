
var myApp = angular.module('myApp', [
    'ngRoute',
    'LoginController'
]);

myApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/login', {
                templateUrl: 'template/login',
                controller: 'LoginController'
            }).
            otherwise({
                redirectTo: '/inscription'
            });
    }]);