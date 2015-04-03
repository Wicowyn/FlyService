/**
 * Created by jbleh_000 on 06/03/2015.
 */

var control = angular.module("createUserModule", []);

control.controller ( "createUserController", function ($scope, $http, $location) {

    $scope.tryCreateUser= function ( ) {

        $http.put("/user/register", {
            name : $scope.name,
            login : $scope.login,
            password : $scope.password
        })
            .success(function(data, status, headers, config) {
                console.log(data);
                if(data.status==42) {
                    //$rootScope.token=data.token;
                    $location.path("/hotel");
                }
                else if(data.status==2) {
                    $scope.error="Champs manquant";
                }
                else if(data.status==8) {
                    $scope.error="Pseudo déjà prit";
                }
            });
    };
});