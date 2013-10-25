billRive.factory('billService', function($http) {
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
        "billId": null,
        "itemDescription": null,
        "simpleUserIdAndLiableCost": [
        ],
        "itemDescriptionId": 2
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

//userAndLiableCost Object Structure
    var userAndLiableCost =
            {userId: null, liableCost: null};

    return {
        addBill: function(userId, Bill) {
            return $http.post(url + userId + "/bill/", Bill);
        },
        deleteBill: function(Bill) {
            return $http.delete(url + Bill.Id);
        },
        updateBill: function(Bill) {
            return $http.put(url + Bill.Id, Bill);
        },
        getPayers: function() {
            return payers;
        },
        getFriends: function() {
            return friends;
        },
        getGroups: function() {
            return groups;
       },
        getBillObj: function() {
            return billObj;
        },
        getUserAndLiableCost: function() {
            return userAndLiableCost;
        },
        getBillSimpleEntryObj: function() {
            return billSimpleEntryObj;
        },
        getSimpleUserIdAndLiableCostObj: function() {
            return simpleUserIdAndLiableCostObj;
        }
    };
});