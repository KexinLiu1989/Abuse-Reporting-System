define(['angular'], function(angular) {
	return ['$scope', '$http', '$filter', '$q', 'ngTableParams', function($scope, $http, $filter, $q, ngTableParams) {

        var data = [{id: 1, name: "Moroni", age: 50, money: -10},
            {id: 2, name: "Tiancum", age: 43,money: 120},
            {id: 3, name: "Jacob", age: 27, money: 5.5},
            {id: 4, name: "Nephi", age: 29,money: -54},
            {id: 5, name: "Enos", age: 34,money: 110},
            {id: 6, name: "Tiancum", age: 43, money: 1000},
            {id: 7, name: "Jacob", age: 27,money: -201},
            {id: 8, name: "Nephi", age: 29, money: 100},
            {id: 9, name: "Enos", age: 34, money: -52.5},
            {id: 10, name: "Tiancum", age: 43, money: 52.1},
            {id: 11, name: "Jacob", age: 27, money: 110},
            {id: 12, name: "Nephi", age: 29, money: -55},
            {id: 13, name: "Enos", age: 34, money: 551},
            {id: 14, name: "Tiancum", age: 43, money: -1410},
            {id: 15, name: "Jacob", age: 27, money: 410},
            {id: 16, name: "Nephi", age: 29, money: 100},
            {id: 17, name: "Enos", age: 34, money: -100}];

        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10           // count per page
        }, {
            total: data.length, // length of data
            getData: function($defer, params) {
                // use build-in angular filter
                var orderedData = params.sorting() ?
                    $filter('orderBy')(data, params.orderBy()) :
                    data;
                orderedData = params.filter() ?
                    $filter('filter')(orderedData, params.filter()) :
                    orderedData;

                params.total(orderedData.length); // set total for recalc pagination
                $defer.resolve($scope.users = orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });



        $scope.checkboxes = { 'checked': false, items: {} };

        // watch for check all checkbox
        $scope.$watch('checkboxes.checked', function(value) {
            angular.forEach($scope.users, function(item) {
                if (angular.isDefined(item.id)) {
                    $scope.checkboxes.items[item.id] = value;
                }
            });
        });

        // watch for data checkboxes
        $scope.$watch('checkboxes.items', function(values) {
            if (!$scope.users) {
                return;
            }
            var checked = 0, unchecked = 0,
                total = $scope.users.length;
            angular.forEach($scope.users, function(item) {
                checked   +=  ($scope.checkboxes.items[item.id]) || 0;
                unchecked += (!$scope.checkboxes.items[item.id]) || 0;
            });
            if ((unchecked == 0) || (checked == 0)) {
                $scope.checkboxes.checked = (checked == total);
            }
            // grayed checkbox
            angular.element(document.getElementById("select_all")).prop("indeterminate", (checked != 0 && unchecked != 0));
        }, true);

        // because this has happened asynchroneusly we've missed
        // Angular's initial call to $apply after the controller has been loaded
        // hence we need to explicityly call it at the end of our Controller constructor
        $scope.$apply();

	}];
});