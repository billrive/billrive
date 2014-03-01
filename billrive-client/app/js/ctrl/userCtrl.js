billRive.controller('userCtrl', function(univService,$scope,$cookieStore) {
//  $scope.isUserLoggedIn = univService.getIsUserLoggedIn();
  $scope.isUserLoggedIn = function(){
         console.log($cookieStore.get('authdata'));
           if($cookieStore.get('authdata')===undefined)
            return false;
        else
            return true;
        };
  
  
  
//console.log($scope.isUserLoggedIn);
});

