/**
 * Created by jbleh_000 on 13/03/2015.
 */

var control = angular.module('flyModule', []);

control.controller ( "flyController", function ($scope, $http) {
    $scope.data = [
        {id:1, title:'Foo', desc:'More stuff about this here', category_name:'Category 1'},
        {id:2, title:'Goo', desc:'More stuff about this here', category_name:'Category 2'},
        {id:3, title:'Roo', desc:'Blah details on Roo are here', category_name:'Category 1'},
        {id:4, title:'Hoo', desc:'More stuff about Hoo here', category_name:'Category 2'},
        {id:5, title:'Woo', desc:'More stuff about this here', category_name:'Category 3'}
    ];

    $scope.setSelectedItem = function(i){
        $scope.selectedItem = i;
    };

    $scope.deleteItem = function(){
        if ($scope.selectedItem >= 0) {
            $scope.data.splice($scope.selectedItem,1);
        }
    };
});





//$(document).ready(function() {});