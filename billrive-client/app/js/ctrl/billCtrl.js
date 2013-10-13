billRive.controller('billCtrl', function($location,$scope, billService,userService,Restangular) {
    //initialization
//    $scope.friends = billService.getFriends();
    $scope.groups = [];//billService.getGroups();
//    $scope.payers = billService.getPayers();
     $scope.bills=[];
     $scope.emptySpace=" ";
    Restangular.one("user",6).get().then(function(user){
         $scope.user=user;
         $scope.bills = user.groups[0].bills;
         $scope.groups=user.groups;
    });//[];//$scope.user.groups[0].bills;
//    $scope.user = userService.getUser();//[];//$scope.user.groups[0].bills;
   //[];//$scope.user.groups[0].bills;
    $scope.bill = angular.copy(billService.getBillObj());
//     $scope.bill.billSimpleEntry={};
//     $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost = [];
$scope.setBillGroup = function() {
     $scope.bill.billSimpleEntry=angular.copy(billService.getBillSimpleEntryObj());
//     $scope.bill.billSimpleEntry=billService.getBillSimpleEntryObj();
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
//        var $groupSimpleUserAndLiableCost = [];
//        var $friendNamefromId = null;
        var simpleUserIdAndLiableCostObj=null;
        for (i = 0; i < $selectedGroupMembers.length; i++) {
 simpleUserIdAndLiableCostObj=billService.getSimpleUserIdAndLiableCostObj();
simpleUserIdAndLiableCostObj.userId=$selectedGroupMembers[i].id;
simpleUserIdAndLiableCostObj.user.fName=$selectedGroupMembers[i].fName;
simpleUserIdAndLiableCostObj.user.lName=$selectedGroupMembers[i].lName;
 $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost.push(angular.copy(simpleUserIdAndLiableCostObj));
//            for (var j = 0; j < $scope.friends.length; j++) {
//                if ($scope.friends[j].id == $selectedGroupMembers[i])
//                    $friendNamefromId = $scope.friends[j].name;
//            }
//             $scope.bill.billSimpleEntry.push({userId: $selectedGroupMembers[i]., liableCost: null, name: $friendNamefromId, enabled: true});
//            $groupSimpleUserAndLiableCost.push({userId: $selectedGroupMembers[i], liableCost: null, name: $friendNamefromId, enabled: true});
        }
//         $scope.billSimpleEntry.simpleUserIdAndLiableCost = $groupSimpleUserAndLiableCost;
//        $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost = $groupSimpleUserAndLiableCost;
//        $groupSimpleUserAndLiableCost = [];
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
        $scope.bills.push(angular.copy($scope.bill));
//        billService.addBill(bill);
//billService.addBill(bill);
        $scope.bill = angular.copy(billService.getBillObj())
        $location.url('/');
    };
});



billRive.controller('BillEditCtrl', function($scope, billService, $location, $routeParams) {
    $scope.bill = $scope.bills[$routeParams.id];
    console.log("in billedit ctrl");
    $scope.editBill = function() {
        $scope.bills[$routeParams.id] = $scope.bill;
        $scope.bill = [];
    };
});