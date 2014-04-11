define([], function() {
	return ['$scope', '$http', function($scope, $http) {

        // create angular app
        var validationApp = angular.module('validationApp', []);

        // create angular controller
        validationApp.controller('mainController', function($scope) {

            // function to submit the form after all validation has occurred
            $scope.submitForm = function() {

                // check to make sure the form is completely valid
                if ($scope.userForm.$valid) {
                    alert('our form is amazing');
                }

            };

        });

        // because this has happened asynchroneusly we've missed
        // Angular's initial call to $apply after the controller has been loaded
        // hence we need to explicityly call it at the end of our Controller constructor
        $scope.$apply();
	}];
});