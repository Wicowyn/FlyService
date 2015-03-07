/**
 * Created by yapiti on 06/03/15.
 */

var app = angular.module ( "appModule", [
    "loginModule"
]);

var control = angular.module("loginModule", []);

control.controller ( "LoginController", function ($scope, $http) {
    //$scope.name =[ "Lolo" ] ;

    $scope.tryLogin= function ( ) {

        $http.put("/user/login", {
            login : $scope.login,
            password : $scope.password
        })
        .success(function(data, status, headers, config) {
                console.log(data);
            });
    };
});