billRive.controller('groupCtrl', function($scope, univService,groupService, $location, $routeParams) {
    
   
   groupService.getGroupsFromHttp(6).then(function() {
    
       $scope.group = groupService.getGroups();
    
    });
    
     $scope.setNewGroupMembership=function(){
        
        for (i = 0; i < $scope.user.friends.length; i++) {
            var match=false;
            //id is disabled
             if($scope.user.friends[i].addToGroup ==true){
                 {
                     //if it is already added, ignore
                       for(j=0;j<$scope.group.users.length;j++)
                     {
                         if($scope.group.users[j].id==$scope.user.friends[i].id)
                           match=true;
                     }
                     if(!match)
                            $scope.group.users.push(angular.copy($scope.user.friends[i]));   
                        match=false;
                 }
             }
           
                //id is enabled
             else{
             if ($scope.user.friends[i].addToGroup == false)
                {
                 for(j=0;j<$scope.group.users.length;j++)
                     {
                         if($scope.group.users[j].id==$scope.user.friends[i].id)
                              { 
                                  $scope.group.users.splice(j,1);

                              }
                     }
                   
                }
             }
        }
    };
    
     $scope.addGroup = function() {
        console.log(JSON.stringify($scope.group));
        univService.addGroup(angular.copy($scope.group));
        $location.url('/');
    };
});