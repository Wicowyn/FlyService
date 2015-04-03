/**
 * Created by yapiti on 06/03/15.
 */

var control = angular.module("LoginModule", []);

control.controller ( "LoginController", function ($scope, $http, $rootScope, $location) {
    //$scope.name =[ "Lolo" ] ;

    $scope.tryLogin= function ( ) {

        $http.put("/user/login", {
            login : $scope.login,
            password : $scope.password
        })
        .success(function(data, status, headers, config) {
                console.log(data);
                if(data.status==42) {
                    $rootScope.token=data.token;
                    $location.path("/hotel")
                }
                else if(data.status==2) {
                    $scope.error="Champs manquant";
                }
                else if(data.status==6) {
                    $scope.error="Informations incorrects";
                }
            });
    };
});