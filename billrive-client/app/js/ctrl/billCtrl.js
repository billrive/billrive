billRive.controller('billCtrl', function($scope, billService,userService,Restangular) {
    //initialization
//    $scope.friends = billService.getFriends();
    $scope.groups = [];//billService.getGroups();
//    $scope.payers = billService.getPayers();
     $scope.bills=[];
    Restangular.one("user",6).get().then(function(user){
         $scope.user=user;
         $scope.bills = user.groups[0].bills;
         $scope.groups=user.groups;
    });//[];//$scope.user.groups[0].bills;
//    $scope.user = userService.getUser();//[];//$scope.user.groups[0].bills;
   //[];//$scope.user.groups[0].bills;
    $scope.bill = billService.getBillObj();
//     $scope.bill.billSimpleEntry={};
//     $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost = [];
$scope.setBillGroup = function() {
        var $groupId = $scope.bill.groupId;

        var $groupMembers;
        for (var i = 0; i < $scope.groups.length; i++) {
            var obj = $scope.groups[i];
            if (obj.id == $groupId)
            {
                $groupMembers = obj.users;
            }
        }
        var $groupUserAndLiableCost = [];
        var $friendNamefromId = null;
        for (i = 0; i < $groupMembers.length; i++) {

            for (var j = 0; j < $scope.friends.length; j++) {
                if ($scope.friends[j].id == $groupMembers[i])
                    $friendNamefromId = $scope.friends[j].name;
            }
            $groupUserAndLiableCost.push({userId: $groupMembers[i], liableCost: null, name: $friendNamefromId, enabled: true});
        }
//         $scope.billSimpleEntry.simpleUserIdAndLiableCost = $groupUserAndLiableCost;
        $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost = $groupUserAndLiableCost;
        $groupUserAndLiableCost = [];
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
            if ($scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].enabled === false)
                $scope.bill.billSimpleEntry.simpleUserIdAndLiableCost[i].liableCost = 0;
        }

        $scope.simpleCalculateSum();
    };
    $scope.addBill = function() {
        $scope.bills.push(jQuery.extend(true, {}, $scope.bill));
//        $scope.bills.push(angular.copy($scope.bill));
//        billService.addBill(bill);
//billService.addBill(bill);
        $scope.bill = billService.getBillObj();
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