billRive.controller('loginCtrl', function($scope, $rootScope, $location, billService) {
    //reset before showing login page
    $scope.user = {username: '', password: ''};
    $rootScope.loggedIn = true;
    $rootScope.loggedInUser = {name: 'user', username: 'password'};

    $scope.login = function() {
        console.log(" I am here ");
        //make a service call to get these details
        $rootScope.loggedIn = true;
        $rootScope.loggedInUser = {name: 'Teja Kantamneni', username: 'tkantamneni'};
        $location.path('/bills/list');
        
        //$scope.loginError = true; //set this when login returns error
    };
});