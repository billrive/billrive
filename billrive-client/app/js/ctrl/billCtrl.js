billRive.controller('billCtrl', function($location, $scope, univService,$routeParams,Auth) {
     $scope.isUserLoggedIn = univService.getIsUserLoggedIn();
$scope.editGroupId=$routeParams.groupId;
$scope.editBillId=$routeParams.billId;
//$scope.isCollapsed = false;
    $scope.groups = [];
    $scope.bills = [];
    $scope.emptySpace = " ";
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
          $scope.simpleCalculateSum();
    }
    else{

    $scope.bill = angular.copy(univService.getBillObj());
    }
    }
//univService.getUserFromHttp(6).then(function() {
//    $scope.user = univService.getUser();
//    $scope.bills = $scope.user.groups[0].bills;
//    $scope.groups=$scope.user.groups;
//    
//    if($scope.editGroupId!=null && $scope.editBillId!=null)
//    {
//        $scope.bill =  angular.copy($scope.bills[$scope.editBillId]);
//          $scope.simpleCalculateSum();
//    }
//    else{
//
//    $scope.bill = angular.copy(univService.getBillObj());
//    }
//  });
  

    $scope.setBillGroup = function() {
        $scope.bill.billSimpleEntry = angular.copy(univService.getBillSimpleEntryObj());
        var $groupId = $scope.bill.groupId;

        var $selectedGroupMembers;
        //Let's find the group that the user selected to extract it's data
        for (var i = 0; i < $scope.groups.length; i++) {
            var selectedGroup = $scope.groups[i];
            if (selectedGroup.id == $groupId)
            {
                $selectedGroupMembers = selectedGroup.users;
            }
        }
        var simpleUserIdAndLiableCostObj = null;
        for (i = 0; i < $selectedGroupMembers.length; i++) {
            simpleUserIdAndLiableCostObj = univService.getSimpleUserIdAndLiableCostObj();
            simpleUserIdAndLiableCostObj.userId = $selectedGroupMembers[i].id;
            simpleUserIdAndLiableCostObj.user.fName = $selectedGroupMembers[i].fName;
            simpleUserIdAndLiableCostObj.user.lName = $selectedGroupMembers[i].lName;
            $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost.push(angular.copy(simpleUserIdAndLiableCostObj));
        }
        $scope.simpleCalculatedTotal = 0;

    };

    $scope.simpleCalculateSum = function() {

        $scope.simpleCalculatedTotal = 0;
        for (i = 0; i < $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost.length; i++) {
            if ($scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].liableCost != null)
                $scope.simpleCalculatedTotal += parseFloat($scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].liableCost);
        }


    };

    $scope.simpleFriendEnabled = function() {

        for (i = 0; i < $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost.length; i++) {
            if ($scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].isActive === false)
                $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].liableCost = 0;
        }

        $scope.simpleCalculateSum();
    };
    $scope.addBill = function() {
          $scope.bills.push(jQuery.extend(true, {}, $scope.bill));
//console.log(JSON.stringify($scope.bill));
$scope.bill.billDate=Date.parse($scope.bill.billDate);
        univService.addBill(angular.copy($scope.bill));
        $location.url('/');
    };
    $scope.deleteBill = function(billId) {
        univService.deleteBill(billId).then(function(data){
            
            $location.url('/');
        });
    };
    
    $scope.editBill = function() {
//        console.log($scope.bill);
        delete $scope.bill.isCollapsed;
       univService.editBill($scope.bill.id,$scope.bill).then(function(data){
            $scope.bill = angular.copy(univService.getBillObj());
            
            $location.url('/');
        });
    };
//    console.log(JSON.stringify($routeParams));
});
