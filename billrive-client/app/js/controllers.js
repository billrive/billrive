billRive.controller('billController', function($scope, billService) {

    //$scope.bills= billService.getBills();

    $scope.friends = billService.getFriends();
    $scope.groups = billService.getGroups();
    $scope.payers = billService.getPayers();

    $scope.bill = billService.getBill();
    var $userAndLiableCost = billService.getUserAndLiableCost();

    $scope.addBill = function() {

    };
    //console.log( $scope.friends);

    $scope.setBillGroup = function() {
//         console.log(id);
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
        console.log($scope.friends[0].id);
        var $friendNamefromId = null;
        for (i = 0; i < $groupMembers.length; i++) {

            for (var j = 0; j < $scope.friends.length; j++) {

                //
                if ($scope.friends[j].id == $groupMembers[i])
                {
                    $friendNamefromId = $scope.friends[j].name;
                }
                //
            }
            $groupUserAndLiableCost.push({userId: $groupMembers[i], liableCost: null, name: $friendNamefromId});
        }

        //console.log($groupUserAndLiableCost);
//         for(var i=0;i<)
//         var $userAndLiableCost=
        $scope.bill.billFinances.billItemEntry = $groupUserAndLiableCost;
        $groupUserAndLiableCost = [];
        //$scope.bill.billFinances.billItemEntry.push($groupUserAndLiableCost);
        //console.log($userAndLiableCost);
    };


//    billService.getBills(function(data) {
//     $scope.bills = data;
//     $scope.username ="Prashanth";
//    
//
//$scope.friends= [
//{name:'John Doe'},
//{name:'Kristen Stewart'},
//{name:'Trevor Pott'},
//{name:'Hilda Hess'},
//{name:'Gavin Mays'}
//];
//
//
//$scope.groups= [
//{name:'SLC Roommates'},
//{name:'Denver Old Buddies'},
//{name:'Ski Club'},
//{name:'Family'},
//{name:'India'}
//];
//
//     function addBill(){
//         
////         $scope.bills.put();
//     };
//     
//      function deleteBill(){
//         
//         
//     };
//     
//      function editBill(){
//         
//         
//     };
//  });
});

