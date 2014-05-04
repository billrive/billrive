billRive.controller('groupCtrl', function($scope, univService, $location, $routeParams) {
    
   
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
    
    if($scope.editGroupId!=null && $scope.editGroupId!=null)
    {
        $scope.bill =  angular.copy($scope.bills[$scope.editBillId]);
//          $scope.simpleCalculateSum();
    }
    else{
    $scope.group = univService.getGroupObj();
    $scope.addGroupAddOwnerToJSON();
//    $scope.bill = angular.copy(univService.getBillObj());
    }
    
    }
    
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
        univService.addGroup(angular.copy($scope.group));
//        $location.url('/');
    };
    
     $scope.addGroupAddOwnerToJSON = function() {
       $scope.groupOwner={};
       $scope.groupOwner.id=$scope.user.id;
       $scope.groupOwner.fName=$scope.user.fName;
       $scope.groupOwner.lName=$scope.user.lName;
       $scope.groupOwner.email=$scope.user.email;
       $scope.groupOwner.mName=$scope.user.mName;
       $scope.groupOwner.title=$scope.user.title;
       $scope.groupOwner.userActive=false;
       $scope.groupOwner.addToGroup=true;
       $scope.group.users.push(angular.copy($scope.groupOwner));
       
    };
});