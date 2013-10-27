billRive.controller('billCtrl', function($location, $scope, univService,$routeParams) {
//$locationProvider.html5Mode(true);
$scope.edit=$routeParams.groupId;
    $scope.groups = [];
    $scope.bills = [];
    $scope.emptySpace = " ";
univService.getUserFromHttp(6).then(function() {
    $scope.user = univService.getUser();
    $scope.bills = $scope.user.groups[0].bills;
    $scope.groups=$scope.user.groups;
  });

    $scope.bill = angular.copy(univService.getBillObj());
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
//        $scope.bills.push(jQuery.extend(true, {}, $scope.bill));
//        $scope.bills.push(angular.copy($scope.bill));
console.log($scope.bill);
//console.log(JSON.stringify($scope.bill));
$scope.bill.billDate=Date.parse($scope.bill.billDate);
        univService.addBill($scope.bill.groupId,angular.copy($scope.bill));
//        $scope.bill = angular.copy(univService.getBillObj());
        $location.url('/');
    };
    $scope.deleteBill = function(billId) {
//        $scope.bills.push(jQuery.extend(true, {}, $scope.bill));
//        $scope.bills.push(angular.copy($scope.bill));
        univService.deleteBill(billId).success(function(data){
            
            $location.url('/');
        });
//        $scope.bill = angular.copy(univService.getBillObj());
        
//        $scope.$apply()
    };
    console.log(JSON.stringify($routeParams));
});



billRive.controller('BillEditCtrl', function($scope, univService, $location, $routeParams) {
    $scope.bill = $scope.bills[$routeParams.id];
    console.log("in billedit ctrl");
    $scope.editBill = function() {
        $scope.bills[$routeParams.id] = $scope.bill;
        $scope.bill = [];
    };
});