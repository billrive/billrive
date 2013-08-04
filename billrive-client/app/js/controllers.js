billRive.controller('billController', function($scope, billService) {
    //initialization
    $scope.friends = billService.getFriends();
    $scope.groups = billService.getGroups();
    $scope.payers = billService.getPayers();
    $scope.simpleUserCostMap = [];
    $scope.bills = billService.getBills();
    $scope.bill = [];
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
//         $scope.simpleUserCostMap = $groupUserAndLiableCost;
        $scope.simpleUserCostMap = $groupUserAndLiableCost;
        $groupUserAndLiableCost = [];
        $scope.simpleCalculatedTotal = 0;

    };

    $scope.simpleCalculateSum = function() {

        $scope.simpleCalculatedTotal = 0;
        for (i = 0; i < $scope.simpleUserCostMap.length; i++) {
            if ($scope.simpleUserCostMap[i].liableCost != null)
                $scope.simpleCalculatedTotal += parseInt($scope.simpleUserCostMap[i].liableCost);
        }


    };
    $scope.simpleFriendEnabled = function() {

        for (i = 0; i < $scope.simpleUserCostMap.length; i++) {
            if ($scope.simpleUserCostMap[i].enabled === false)
                $scope.simpleUserCostMap[i].liableCost = 0;
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
        $scope.bills.push(jQuery.extend(true, {}, $scope.bill));
        $scope.bill = [];
        $location.url('/');
    };
});
billRive.controller('BillEditCtrl', function($scope, billService, $location, $routeParams) {
    $scope.bill = $scope.bills[$routeParams.id];
    console.log("in billedit ctrl");
    $scope.edit = function() {
        $scope.bills[$routeParams.id] = $scope.bill;
        $scope.bill = [];
    };
});

billRive.controller('GroupAddCtrl', function($scope, billService, $location){
    $scope.newGroup={id:'',users:[],name:''};
    $scope.friends=billService.getFriends();
    for (i = 0; i < $scope.friends.length; i++) {
            $scope.friends[i].addToNewGroup = false;
                
        }


    $scope.setNewGroupMembership=function(){
        
        for (i = 0; i < $scope.friends.length; i++) {
            if ($scope.friends[i].addToNewGroup === false)
                {
                    if($scope.newGroup.users.indexOf($scope.friends[i].id) > -1)
                        {
                            //Delete the friend id from users array of newGroup
                        }
                   
                }
             else
                 {
                      if($scope.newGroup.users.indexOf($scope.friends[i].id) < -1)
                        {
                            
                                //Add the friend id from users array of newGroup
                        }
                       
                 }
        
        }
    };
    
    
    
});

billRive.controller('GroupEditCtrl', function($scope, billService, $location, $routeParams) {
    $scope.group = $scope.groups[$routeParams.id];
    console.log("in groupedit ctrl");
    $scope.edit = function() {
        $scope.groups[$routeParams.id] = $scope.group;
        $scope.group = [];
    };
});
