/**
 * Created by jbleh_000 on 13/03/2015.
 */

var control = angular.module('hotelModule', []);

/********************* LISTING DES HOTELS ********************/
control.controller ( "hotelController", function ($scope, $http) {
    $scope.data = [];

    $http.get("/hotel/list")
        .success(function(rData, status, headers, config) {
            console.log(rData);
            $scope.data=rData;
        });

    $scope.onDelete = function (index) {
        $http.delete("/hotel/"+$scope.data[index].id)
            .success(function(rData, status, headers, config) {

            });

        $scope.data.splice(index, 1);
    };

    $scope.setSelectedItem = function(i){
        $scope.selectedItem = i;
    };

    $scope.deleteItem = function(){
        if ($scope.selectedItem >= 0) {
            $scope.data.splice($scope.selectedItem,1);
        }
    };

        $scope.alerts = [
            { type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
            { type: 'success', msg: 'Well done! You successfully read this important alert message.' }
        ];

        $scope.addAlert = function() {
            $scope.alerts.push({msg: 'Another alert!'});
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };

    /*
    angular.module('ui.bootstrap.demo').controller('AlertDemoCtrl', function ($scope) {
        $scope.alerts = [
            { type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
            { type: 'success', msg: 'Well done! You successfully read this important alert message.' }
        ];

        $scope.addAlert = function() {
            $scope.alerts.push({msg: 'Another alert!'});
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };
    });*/
});

/********************* CREATION D'UN HOTEL ********************/
control.controller ( "hotelCreateController", function ($scope, $http) {
    $scope.data = [];

    $http.put("/hotel/create", $scope.data)
        .success(function(rData, status, headers, config) {
            console.log(rData);
            $scope.data=rData;
        });

    $scope.setSelectedItem = function(i){
        $scope.selectedItem = i;
    };

    $scope.alerts = [
        { type: 'danger', msg: 'Fichtre! La requête était plus grosse que ta mère et c\'est pas passé.' },
        { type: 'success', msg: 'Bien ouéj! Maintenant l\'hotel fait partie de la famille.' }
    ];

    $scope.addAlert = function() {
        $scope.alerts.push({msg: 'Another alert!'});
    };

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };
});