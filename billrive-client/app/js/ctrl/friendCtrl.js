billRive.controller('friendCtrl', function($scope, univService, $location, $routeParams) {
    
   
univService.getUserFromHttp(6).then(function() {
    $scope.user = univService.getUser();   
//    if($scope.editGroupId!=null && $scope.editBillId!=null)
//    {
//        $scope.bill =  angular.copy($scope.bills[$scope.editBillId]);
//          $scope.simpleCalculateSum();
//    }
//    else{
//
//    $scope.bill = angular.copy(univService.getBillObj());
//    }
  });
});