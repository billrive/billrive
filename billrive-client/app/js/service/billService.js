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
//billFinances Object Structure 

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
        "userId": null,
        "liableCost": null,
        "billItemEntryID": null
    };

    var billItemEntryObj = {
        "id": null,
        "itemDescription": null,
        "billId": null,
        "itemDescriptionId": null,
        "userIdAndLiableCost": [
        ]
    };

    var billFinancesObj = {
        "billPayerId": null,
        "billItemEntry": billItemEntryObj,
        "billTotal": null
    };

//billItemEntry Object Structure
    var billItemEntryObj =
            {
                "itemDescriptionId": null,
                "itemDescription": "",
                "userIdAndLiableCost": userAndLiableCost
            };

//userAndLiableCost Object Structure
    var userAndLiableCost =
            {userId: null, liableCost: null};

    var payers = [
        {id: 1, name: 'John Doe'},
        {id: 2, name: 'Kristen Stewart'},
        {id: 3, name: 'Trevor Pott'},
        {id: 4, name: 'Hilda Hess'},
        {id: 5, name: 'Gavin Mays'}
    ];

    var friends = [
        {id: 1, groups: [1, 2, 5], name: 'John Doe'},
        {id: 2, groups: [1, 2, 3, 4, 5], name: 'Kris Stewart'},
        {id: 3, groups: [1, 3, 5], name: 'Trevor Potts'},
        {id: 4, groups: [1], name: 'Hilda Hess'},
        {id: 5, groups: [4, 5], name: 'Gavin Mays'}
    ];


    var groups = [
        {id: 1, users: [1, 2, 3, 4], name: 'SLC Roommates', isActive: 'true'},
        {id: 2, users: [1, 2], name: 'Denver Old Buddies', isActive: 'false'},
        {id: 3, users: [2, 3], name: 'Ski Club', isActive: 'true'},
        {id: 4, users: [2, 5], name: 'Family', isActive: 'false'},
        {id: 5, users: [1, 2, 3, 5], name: 'India', isActive: 'true'}
    ];

    var groupFriendRel = [{groupId: '1', friendId: '5'}];

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
        billItemEntryObj: function() {
            return billItemEntry;
        },
        getUserAndLiableCost: function() {
            return userAndLiableCost;
        },
        getBillFinances: function() {
            return billFinances;
       },
        getUser: function() {
            return user;
        },
        getBillSimpleEntryObj: function() {
            return billSimpleEntryObj;
        },
        getSimpleUserIdAndLiableCostObj: function() {
            return simpleUserIdAndLiableCostObj;
        }
    };
});