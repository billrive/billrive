billRive.controller('loginCtrl', function($scope, $rootScope, $location, univService,Auth) {
    //reset before showing login page
    $scope.user = {email: '', password: ''};
    $rootScope.loggedIn = true;
    $rootScope.loggedInUser = {name: 'user', username: 'password'};
    $scope.errorMsg="";
    $scope.login = function() {
        Auth.setCredentials($scope.user.email,$scope.user.password);
        $scope.serverResponse="";
        
    $scope.serverResponse= univService.authenticateAndGetUserFromHttp($scope.email,$scope.password)
    .success(function(data, status, headers, config) {
        univService.setUser(angular.copy(data));
       $location.path('/bills/list'); 
       
    }).
    error(function(data, status, headers, config) {
        Auth.clearCredentials();
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