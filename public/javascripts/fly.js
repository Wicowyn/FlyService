/**
 * Created by jbleh_000 on 13/03/2015.
 */

var control = angular.module('flyModule', []);

control.controller ( "flyController", function ($scope, $http) {
    $scope.data = [];

    $http.get("/flight/list")
        .success(function(data, status, headers, config) {
            $scope.data=data;
        });

    $scope.onDelete = function (index) {
        $http.delete("/flight/"+$scope.data[index].id)
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





//$(document).ready(function() {});