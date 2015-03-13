/**
 * Created by yapiti on 06/03/15.
 */

var control = angular.module("LoginController", []);

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