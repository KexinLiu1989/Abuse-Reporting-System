define([
	'angular',
	'filters',
	'services',
	'directives',
	'controllers',
	'angularRoute',
    'ngTable'
	], function (angular, filters, services, directives, controllers) {
		'use strict';

		return angular.module('myApp', [
			'ngRoute',
			'myApp.controllers',
			'myApp.filters',
			'myApp.services',
			'myApp.directives',
            'ngTable'
		]);
});
