
var myApp = angular.module('myApp', [
    'ngRoute',
    'flyModule',
    'hotelModule',
    'LoginModule',
    'createUserModule',
    'filters'
]);

myApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/fly', {
                templateUrl: 'template/fly',
                controller: 'flyController'
            })
            .when('/hotel', {
                templateUrl: 'template/hotel',
                controller: 'hotelController'
            }).
            when('/login', {
                templateUrl: 'template/login',
                controller: 'LoginController'
            }).
            when('/inscription', {
                templateUrl: 'template/inscription',
                controller: 'createUserController'
            }).
            otherwise({
                redirectTo: '/inscription_template'
            });
    }]);