billRive.controller('billController', function($scope, billService) {

    //$scope.bills= billService.getBills();

    $scope.friends = billService.getFriends();
    $scope.groups = billService.getGroups();
    $scope.payers = billService.getPayers();

    $scope.bill = billService.getBill();
    var $userAndLiableCost = billService.getUserAndLiableCost();

    $scope.addBill = function() {

    };

    $scope.setBillGroup = function(id) {
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
        var $groupUserAndLiableCost=[];
        for (var i = 0; i < $groupMembers.length; i++) {
          $groupUserAndLiableCost.push({userId:$groupMembers[i],liableCost:null});
        }
        
        console.log($groupUserAndLiableCost);
//         for(var i=0;i<)
//         var $userAndLiableCost=
        $scope.bill.billFinances.billItemEntry=$groupUserAndLiableCost;
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

