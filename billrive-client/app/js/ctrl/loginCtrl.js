billRive.controller('loginCtrl', function($scope, $rootScope, $location, billService) {
    //reset before showing login page
    $scope.user = {username: '', password: ''};
    $rootScope.loggedIn = false;
    $rootScope.loggedInUser = null;

    $scope.login = function() {
        //make a service call to get these details
        $rootScope.loggedIn = true;
        $rootScope.loggedInUser = {name: 'Teja Kantamneni', username: 'tkantamneni'};
        $location.path('/bills/list');
        
        //$scope.loginError = true; //set this when login returns error
    };
});