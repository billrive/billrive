billRive.controller('billController', function($scope, billService) {
    $scope.friends = billService.getFriends();
    $scope.groups = billService.getGroups();
    $scope.payers = billService.getPayers();

    $scope.bill = billService.getBill();
    var $userAndLiableCost = billService.getUserAndLiableCost();

    $scope.addBill = function() {

    };
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
            $groupUserAndLiableCost.push({userId: $groupMembers[i], liableCost: null, name: $friendNamefromId,enabled:true});
        }
        $scope.bill.billFinances.billSimpleTotals.userIdAndLiableCost = $groupUserAndLiableCost;
        $groupUserAndLiableCost = [];
$scope.simpleCalculatedTotal=0;
    };

$scope.calculateSimpleSum=function(){

 $scope.simpleCalculatedTotal=0;
 for (i = 0; i < $scope.bill.billFinances.billSimpleTotals.userIdAndLiableCost.length; i++) {
     if($scope.bill.billFinances.billSimpleTotals.userIdAndLiableCost[i].liableCost!=null)
        $scope.simpleCalculatedTotal+= parseInt($scope.bill.billFinances.billSimpleTotals.userIdAndLiableCost[i].liableCost);
 }

    
};

});

