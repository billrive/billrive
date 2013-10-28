billRive.controller('groupCtrl', function($scope, univService, $location, $routeParams) {
    
   
   univService.getUserFromHttp(6).then(function() {
    $scope.user = univService.getUser();
    $scope.bills = $scope.user.groups[0].bills;
    $scope.groups=$scope.user.groups;
    
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
    $scope.GroupEditEnv=function(){
        
            for (i = 0; i < $scope.tmpFriends.length; i++) {
            $scope.tmpFriends[i].addToGroup = false;         
        }
    for (i = 0; i < $scope.tmpGroup.users.length; i++) {
        indx =   $scope.tmpGroup.users[i]-1;
        $scope.tmpFriends[indx].addToGroup = true;        
    }
    
    
    };
    $scope.GroupEditCtrl=function(){
        
         $scope.groups[$routeParams.id] = $scope.tmpGroup;
        $scope.tmpGroup = [];
    
    };
    
    $scope.GroupAddCtrl=function(){
         $scope.groups.push(jQuery.extend(true, {}, $scope.tmpGroup));
        $scope.tmpGroup = [];
        $location.url('/');
    };
    
    $scope.GroupDelCtrl=function(){
        
    };
    
     $scope.setNewGroupMembership=function(){
        
        for (i = 0; i < $scope.tmpFriends.length; i++) {
            if ($scope.tmpFriends[i].addToGroup === false)
                {
                    if($scope.tmpGroup.users.indexOf($scope.tmpFriends[i].id) > -1)
                        {
                            $scope.tmpGroup.users.splice($scope.tmpGroup.users.indexOf($scope.tmpFriends[i].id),1);
                            //Delete the friend id from users array of newGroup
                        }
                   
                }
             else
                 {
                      if($scope.tmpGroup.users.indexOf($scope.tmpFriends[i].id) <= -1)
                        {
                           
                            $scope.tmpGroup.users.push($scope.tmpFriends[i].id); 
                            
                                //Add the friend id from users array of newGroup
                        }
                       
                 }
        
        }
    };
});