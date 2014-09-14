billRive.controller('userCtrl', function(univService,$rootScope, $scope,$cookieStore,Auth,$location) {
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
   
   $scope.userName = univService.getUser();
   $rootScope.$on('SetUser', function(event, data){
       $scope.userName = data.fName + ' ' + data.lName;
       univService.setUser(angular.copy(data));
   });
//    $scope.userName = univService.getUser();
//console.log($scope.isUserLoggedIn);
});

