billRive.controller('friendCtrl', function($scope, univService, $location, $routeParams) {
    
$scope.user = univService.getUser();
    if(jQuery.isEmptyObject($scope.user)){
        
        univService.authenticateAndGetUserFromHttp()
    .success(function(data, status, headers, config) {
       univService.setUser(angular.copy(data));
//       univService.setIsUserLoggedIn(true);
//       $location.path('/bills/list'); 
$scope.user=data;
       init();
    }).
    error(function(data, status, headers, config) {
//        Auth.clearCredentials();
        univService.setIsUserLoggedIn(false);
        if(status===401)
          $scope.errorMsg=status+ ":Invalid Email/Password";
         else
             if(status===404)
                 $scope.errorMsg=status+ ":Service is currently unreachable";
         else
             if(status===500)
                 $scope.errorMsg=status+ ":Service is currently experiencing difficulties";
         else
             $scope.errorMsg=status+ ":We are currently experiencing technical difficulties";
        $location.path('/');
        //+" "+"<pre>"+headers+"</pre>";
    });
             
    }
    else
    {
        init();
    }
    
    function init(){
      
    $scope.bills = $scope.user.groups[0].bills;
    $scope.groups=$scope.user.groups;
    
    if($scope.editGroupId!=null && $scope.editBillId!=null)
    {
        $scope.bill =  angular.copy($scope.bills[$scope.editBillId]);
//          $scope.simpleCalculateSum();
    }
    else{

    $scope.bill = angular.copy(univService.getBillObj());
    }
    
    }
});