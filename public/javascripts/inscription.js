/**
 * Created by jbleh_000 on 06/03/2015.
 */

/* inscription.js */

/*
 var app=angular.module("appModule", []);
 app.controller('validateController', ['$scope', function($scope) {
 $scope.name = 'morning';
 $scope.password = 'Nikki';
 }]);

 $scope.name=["Lolo"];
 $scope.password=["LoloPassword"];

 $scope.addName= function() {
 $scope.name.push($scope.newName);
 };
 $scope.addPassword= function() {
 $scope.name.push($scope.newPassword);
 }
 console.log($scope, "name")*/
/*
var control = angular.module("createUserModule", []);
control.controller ( "createUserController", function ($scope, $http) {
    $scope.tryCreateUser = function() {
        console.log($scope, "name");
        $http.put("/user/register", (User.login : $scope.login,  User.password : $scope.password), $http.error(console.log("Utilisateur PAS ajouté avec succes !")));
    }
    $scope.tryCreateUser = function() {
     $http.put("/user/login" ,
     login : $scope.login;
     password : $scope.password;
     })
})*/


var app = angular.module ( "appModule", [
    "createUserModule"
]);

var control = angular.module("createUserModule", []);

control.controller ( "createUserController", function ($scope, $http) {
    //$scope.name =[ "Lolo" ] ;

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