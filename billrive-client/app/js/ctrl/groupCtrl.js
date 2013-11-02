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
    $scope.group = angular.copy(univService.getGroupObj());
//    }
  });
    $scope.GroupEditEnv=function(){
        
            for (i = 0; i < $scope.groups.length; i++) {
            $scope.groups[i].addToGroup = false;         
        }
    for (i = 0; i < $scope.tmpGroup.users.length; i++) {
        indx =   $scope.tmpGroup.users[i]-1;
        $scope.groups[indx].addToGroup = true;        
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
        
        for (i = 0; i < $scope.groups.length; i++) {
            if ($scope.groups[i].addToGroup === false)
                {
                    if($scope.tmpGroup.users.indexOf($scope.groups[i].id) > -1)
                        {
                            $scope.tmpGroup.users.splice($scope.tmpGroup.users.indexOf($scope.groups[i].id),1);
                            //Delete the friend id from users array of newGroup
                        }
                   
                }
             else
                 {
                      if($scope.tmpGroup.users.indexOf($scope.groups[i].id) <= -1)
                        {
                           
                            $scope.tmpGroup.users.push($scope.groups[i].id); 
                            
                                //Add the friend id from users array of newGroup
                        }
                       
                 }
        
        }
    };
});