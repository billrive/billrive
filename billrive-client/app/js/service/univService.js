billRive.factory('univService', function($http, $q) {
    var url = 'http://localhost\:8080/billrive-service/user/';

    var billObj = {
        "id": null,
        "title": "",
        "billDate": null,
        "billPayerId": null,
        "notes": null,
        "billCreaterId": null,
        "groupId": null,
        "billTotal": null,
        "billSimpleEntry": billSimpleEntryObj,
        "billItemEntry": [
        ],
        "userId": null
    };

    var billSimpleEntryObj = {
        "id": null,
        "itemDescription": null,
        "simpleUserIdAndLiableCost": [
        ]
//        ,
//        "itemDescriptionId": 2
    };

    var simpleUserIdAndLiableCostObj = {
        "userId": null,
        "liableCost": null,
        "id": null,
        "billSimpleEntryId": null,
        "user": {
            "id": null,
            "fName": null,
            "lName": null
        },
        "isActive": true
    };

    var billItemEntryObj = {
        "id": null,
        "itemDescription": null,
        "billId": null,
        "itemDescriptionId": null,
        "userIdAndLiableCost": [
        ]
    };
    var deffered = $q.defer();
    var user = {};


    var currUserId = 6;

    var userAndLiableCost =
            {userId: null, liableCost: null};

    return {
        getUser: function() {
            return user;
        },
        getUserFromHttp: function(userId) {
            $http.get(url + userId)
                    .success(function(d) {
                        user = d;
                        console.log(d);
                        deffered.resolve();
                    });
            return deffered.promise;
        },
        deleteUser: function(User) {
            return $http.delete(url + User.Id);
        },
        addUser: function(User) {
            return $http.put(url + User.Id, User);
        },
        addBill: function(Bill) {
            user.groups[0].bills.push(Bill);
            return $http.post(url + currUserId + "/bill/", Bill);
        },
        deleteBill: function(billId) {
            return $http.delete(url + currUserId + "/bill/"+billId);
        },
        editBill: function(billId, Bill) {
            return $http.put(url + currUserId + "/bill/"+billId, Bill);
        },
        getBillObj: function() {
            return billObj;
        },
        getBillItemEntryObjt: function() {
            return billItemEntryObj;
        },
        getUserAndLiableCost: function() {
            return userAndLiableCost;
        },
        getBillSimpleEntryObj: function() {
            return billSimpleEntryObj;
        },
        getSimpleUserIdAndLiableCostObj: function() {
            return simpleUserIdAndLiableCostObj;
        },
        setCurrUserId: function(userId) {
            currUserId = userId;
        },
        getCurrUserId: function() {
            return currUserId;
        },
         addGroup: function(Group) {
            user.groups[0].groups.push(Group);
            return $http.post(url + currUserId + "/group/", Group);
        },
        deleteGroup: function(groupId) {
            return $http.delete(url + currUserId + "/group/"+groupId);
        },
        editGroup: function(groupId, Group) {
            return $http.put(url + currUserId + "/group/"+groupId, Group);
        }
    };
});