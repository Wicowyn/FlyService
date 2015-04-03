/**
 * Created by jbleh_000 on 13/03/2015.
 */

var control = angular.module('hotelModule', []);

/********************* LISTING DES HOTELS ********************/
control.controller ( "listHotelController", function ($scope, $http) {
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
control.controller ( "createHotelController", function ($scope, $http) {

    $scope.tryCreateHotel= function ( ) {

        $http.put("/hotel/create", {
            name : $scope.name,
            adresse : $scope.adr,
            description : $scope.desc
        })
        .success(function(data, status, headers, config) {
            console.log(data);
        });
    };
});