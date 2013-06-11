billRive.controller('billController', function($scope, billService) {
    $scope.friends = billService.getFriends();
    $scope.groups = billService.getGroups();
    $scope.payers = billService.getPayers();  
    $scope.simpleUserCostMap=[];
$scope.bills= [];
//    $scope.bill = billService.getBill();
    $scope.bill =[];//= billService.getBill();

    $scope.setBillGroup = function() {
        //console.log('hello');
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
//         $scope.simpleUserCostMap = $groupUserAndLiableCost;
        $scope.simpleUserCostMap = $groupUserAndLiableCost;
        $groupUserAndLiableCost = [];
$scope.simpleCalculatedTotal=0;
    
    };

$scope.simpleCalculateSum=function(){

 $scope.simpleCalculatedTotal=0;
 for (i = 0; i <  $scope.simpleUserCostMap.length; i++) {
     if( $scope.simpleUserCostMap[i].liableCost!=null)
        $scope.simpleCalculatedTotal+= parseInt( $scope.simpleUserCostMap[i].liableCost);
 }

    
};
$scope.simpleFriendEnabled=function(){

 for (i = 0; i <  $scope.simpleUserCostMap.length; i++) {
     if( $scope.simpleUserCostMap[i].enabled===false)
         $scope.simpleUserCostMap[i].liableCost=0;
 }

  $scope.simpleCalculateSum();  
};

});

billRive.controller('BillListCtrl', function($scope, billService) {
    $scope.listBills = function() {

    };
});
billRive.controller('BillAddCtrl', function($scope, billService, $location) {
    
    $scope.addBill = function() {
        $scope.bills.push($scope.bill);
        $scope.bill = [];
       // $scope.bill=billService.getBill();
        $location.url('/');
    };
});