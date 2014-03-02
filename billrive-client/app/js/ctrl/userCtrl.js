billRive.controller('userCtrl', function(univService,$scope,$cookieStore,Auth,$location) {
//  $scope.isUserLoggedIn = univService.getIsUserLoggedIn();
  $scope.isUserLoggedIn = function(){
//         console.log($cookieStore.get('authdata'));
           if($cookieStore.get('authdata')===undefined)
            return false;
        else
            return true;
        };
  
   $scope.logout = function() {
          Auth.clearCredentials();
          $location.path('/'); 
      };
  
//console.log($scope.isUserLoggedIn);
});

