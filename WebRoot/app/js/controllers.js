define(['angular', 'services'], function (angular) {
	'use strict';

	return angular.module('myApp.controllers', ['myApp.services'])
        .controller('menu', ['$scope', '$location', function ($scope, $location) {
            // putting $location as a $scope instance variable
            // so that we could set "active" class based on current $location.path
            $scope.location = $location;
        }])
		.controller('loginCtrl', ['$scope', '$http', '$injector', function ($scope, $http, $injector) {
            require(['controllers/loginCtrl'], function(ctrl) {
                // injector method takes an array of modules as the first argument
                // if you want your controller to be able to use components from
                // any of your other modules, make sure you include it together with 'ng'
                // Furthermore we need to pass on the $scope as it's unique to this controller
                $injector.invoke(ctrl, this, { '$scope': $scope, '$http': $http });
            });
		}])
		.controller('createReportCtrl', ['$scope', '$http', '$injector', function ($scope, $http, $injector) {
			require(['controllers/createReportCtrl'], function(ctrl) {
                $injector.invoke(ctrl, this, { '$scope': $scope, '$http': $http });
			});
		}])
		.controller('reportListCtrl', ['$scope', '$http', '$injector', '$filter', '$q', 'ngTableParams', function ($scope, $http, $injector, $filter, $q, ngTableParams) {
			require(['controllers/reportListCtrl'], function(ctrl) {
                $injector.invoke(ctrl, this, { '$scope': $scope, '$http': $http, '$filter': $filter, '$q': $q, 'ngTableParams': ngTableParams });
			});
		}])
		.controller('reportDetailCtrl', ['$scope', '$http', '$injector', function ($scope, $http, $injector) {
			require(['controllers/reportDetailCtrl'], function(ctrl) {
                $injector.invoke(ctrl, this, { '$scope': $scope, '$http': $http });
			});
		}])
		.controller('userCtrl', ['$scope', '$http', '$injector', function ($scope, $http, $injector) {
			require(['controllers/userCtrl'], function(ctrl) {
                $injector.invoke(ctrl, this, { '$scope': $scope, '$http': $http });
			});
		}]);
});