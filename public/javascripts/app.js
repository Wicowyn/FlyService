
var myApp = angular.module('myApp', [
    'ngRoute',
    'LoginModule',
    'createUserModule'
]);

myApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
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