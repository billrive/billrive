billRive.controller('GroupCtrl', function($scope, billService, $location, $routeParams) {
    
   
   
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