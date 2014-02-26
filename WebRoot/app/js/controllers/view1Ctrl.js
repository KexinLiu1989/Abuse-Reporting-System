define([], function() {
	return ['$scope', '$http', function($scope, $http) {

        // show 'hello' by default
        $scope.showHello = true;
        $scope.helloData = '';

        // fetch data from /hello method
        $scope.getHello = function () {
            $http.get('hello').
                then(function (response) {
                    var data = response.data;

                    // retrieve data that has space in the name
                    $scope.helloData = data['Hello String'];

                });
        };
        $scope.getHello();

        // watch string 'hello' in data
        $scope.$watch('helloData', function() {
            // check whether 'hello' string exists in data, hide 'hello' if so
            if ($scope.helloData.indexOf('Hello') === -1) {
                $scope.showHello = true;
            } else {
                $scope.showHello = false;
            }
        });

	}];
});