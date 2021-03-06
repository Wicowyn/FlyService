
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
                controller: 'listHotelController'
            })
            .when('/create_fly', {
                templateUrl: 'template/fly_create',
                controller: 'createFlyController'
            })
            .when('/listhotel', {
                templateUrl: 'template/listhotel',
                controller: 'listHotelController'
            })
            .when('/createhotel', {
                templateUrl: 'template/createhotel',
                controller: 'createHotelController'
            })
            .when('/login', {
                templateUrl: 'template/login',
                controller: 'LoginController'
            })
            .when('/inscription', {
                templateUrl: 'template/inscription',
                controller: 'createUserController'
            })
            .when('/contact', {
                templateUrl: 'template/contact'
            })
            .when('/about', {
                templateUrl: 'template/about'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }]);