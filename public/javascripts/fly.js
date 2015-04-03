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


control.controller ( "createFlyController", function ($scope, $http, $filter, $location, $rootScope) {
    $scope.hotels = [];
    $scope.hotelSelected = null;

    //if($rootScope.token==null) $location.path("/login");

    $http.get("/hotel/list", {})
        .success(function(data, status, headers, config) {
            $scope.hotels=data;
            $scope.hotelSelected=$scope.hotels[0];
        });

    $scope.hotelChoosed = [];



    $scope.create= function ( ) {
        $http.put("/flight", {
            "start" : $scope.start,
            "end" : $scope.end,
            "start_date" : $filter('date')($scope.start_date, "dd-MM-yyyy"),
            "end_date" : $filter('date')($scope.end_date, "dd-MM-yyyy"),
            "hotels" : [$scope.hotelSelected.id]
        })
            .success(function(data, status, headers, config) {
                console.log(data);

                if(data.status==2) {
                    $scope.error="Champs manquant";
                }
                else if(data.status==4) {
                    $scope.error="Les dates ne sont pas correct";
                }
                else if(data.status==42) {
                    console.log("created");
                    $location.path("/fly");
                }
            });
    };
});

//$(document).ready(function() {});