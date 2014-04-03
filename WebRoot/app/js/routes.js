define(['angular', 'app'], function(angular, app) {
	'use strict';

	return app.config(['$routeProvider', function($routeProvider) {
		$routeProvider.when('/login', {
			templateUrl: 'app/views/login.html',
			controller: 'loginCtrl'
		});
		$routeProvider.when('/createReport', {
			templateUrl: 'app/views/createReport.html',
			controller: 'createReportCtrl'
		});
		$routeProvider.when('/reportList', {
			templateUrl: 'app/views/reportList.html',
			controller: 'reportListCtrl'
		});
		$routeProvider.when('/reportDetail', {
			templateUrl: 'app/views/reportDetail.html',
			controller: 'reportDetailCtrl'
		});
		$routeProvider.when('/user', {
			templateUrl: 'app/views/user.html',
			controller: 'userCtrl'
		});
		$routeProvider.otherwise({redirectTo: '/login'});
	}]);

});