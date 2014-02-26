define([], function() {
	return ['$scope', '$http', function($scope, $http) {

        // get user data from /user method
        $scope.getUser = function () {
            $http.get('user').
                then(function (response) {
                    var data = response.data;
                    // put data into scope
                    $scope.userData = data.users.list;
                });
        };
        $scope.getUser();

	}];
});