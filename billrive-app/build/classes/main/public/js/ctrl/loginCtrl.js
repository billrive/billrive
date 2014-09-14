billRive.controller('loginCtrl', function($rootScope, $scope, $location, univService,Auth,$cookieStore) {
    //reset before showing login page
    $scope.user = {email: '', password: ''};
//    $scope.isUserLoggedIn = univService.getIsUserLoggedIn();
    $scope.errorMsg="";
    $scope.login = function() {
        Auth.setCredentials($scope.user.email,$scope.user.password);
        $scope.serverResponse="";
        
    $scope.serverResponse= univService.authenticateAndGetUserFromHttp()
//    $scope.serverResponse= univService.authenticateAndGetUserFromHttp($scope.email,$scope.password)
    .success(function(data, status, headers, config) {
        if(!jQuery.isEmptyObject(data)){
            univService.setUser(angular.copy(data));
            univService.setIsUserLoggedIn(true);
            $rootScope.$broadcast('SetUser', data);
//            var userName = data.fName + ' ' + data.lName;
//            $cookieStore.put('userName', userName);
            $location.path('/bills/list'); 
        }
        else
        {
            Auth.clearCredentials();
            $scope.errorMsg=status+ ":Unknown error. Paging Chuck Norris for help.";
        }
    }).
    error(function(data, status, headers, config) {
        Auth.clearCredentials();
        univService.setIsUserLoggedIn(false);
        if(status===401)
          $scope.errorMsg=status+ ":Invalid Email/Password";
         else
             if(status===404)
                 $scope.errorMsg=status+ ":Service is currently unreachable. Dev Tip: Check Port settings in univService";
         else
             if(status===500)
                 $scope.errorMsg=status+ ":Service is currently experiencing difficulties";
         else
             $scope.errorMsg=status+ ":We are currently experiencing technical difficulties";
        
        //+" "+"<pre>"+headers+"</pre>";
    });
  
//   if ( $scope.serverResponse == 200) {
//              
//       }
//  else{
//       errorMsg=$scope.serverResponse+ ":Invalid Email/Password";
//    } 
        //$scope.loginError = true; //set this when login returns error
    };
    
      $scope.logout = function() {
          Auth.clearCredentials();
          $location.path('/'); 
      };
      
      $scope.isUserLoggedIn = function(){
//         console.log($cookieStore.get('authdata'));
           if($cookieStore.get('authdata')===undefined)
            return false;
        else
            return true;
        };
      
});