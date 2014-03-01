billRive.controller('loginCtrl', function($scope, $rootScope, $location, univService) {
    //reset before showing login page
    $scope.user = {email: '', password: ''};
    $rootScope.loggedIn = true;
    $rootScope.loggedInUser = {name: 'user', username: 'password'};
    $scope.errorMsg="";
    $scope.login = function() {
        
        $scope.serverResponse="";
        
    $scope.serverResponse= univService.authenticateAndGetUserFromHttp($scope.email,$scope.password)
    .success(function(data, status, headers, config) {
        univService.setUser(angular.copy(data));
       $location.path('/bills/list'); 
       
    }).
    error(function(data, status, headers, config) {
     $scope.errorMsg=status+ ":Invalid Email/Password";//+" "+"<pre>"+headers+"</pre>";
    });
  
//   if ( $scope.serverResponse == 200) {
//              
//       }
//  else{
//       errorMsg=$scope.serverResponse+ ":Invalid Email/Password";
//    } 
        //$scope.loginError = true; //set this when login returns error
    };
});