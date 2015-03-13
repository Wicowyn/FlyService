/**
 * Created by jbleh_000 on 06/03/2015.
 */

var control = angular.module("createUserModule", []);

control.controller ( "createUserController", function ($scope, $http) {

    $scope.tryCreateUser= function ( ) {

        $http.put("/user/register", {
            name : $scope.name,
            login : $scope.login,
            password : $scope.password
        })
            .success(function(data, status, headers, config) {
                console.log(data);
            });
    };
});