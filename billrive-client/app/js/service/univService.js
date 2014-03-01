billRive.factory('univService', function($http, $q, Base64) {
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
    
    var groupObj={
    "id": null,
    "name": null,
    "description": null,
    "ownerId": null,
    "bills": null,
    "payments": null,
    "users": [],
    "isActive": true, 
    "balances": null
};

var friendObj= {
            "id": null,
            "fName": null,
            "lName": null,
            "email": null,
            "mName": null,
            "title": null,
            "userActive": null
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
            
            
//                  $http({method: 'GET', url: "http://localhost:8080/examples/servlets/helloworld.html", headers: {'Authorization': 'Basic ' + Base64.encode('admin' + ':' + 'password')}}).
                  $http({method: 'GET', url: url + userId, headers: {'Authorization': 'Basic ' + Base64.encode('me@prashu.net' + ':' + 'password')}}).
    success(function(data, status, headers, config) {
       user = data;
//                        console.log(d);
                        deffered.resolve();
      // this callback will be called asynchronously
      // when the response is available
    }).
    error(function(data, status, headers, config) {
      // called asynchronously if an error occurs
      // or server returns response with an error status.
    });
//    
//    
//            $http.defaults.headers.common = {"Access-Control-Request-Headers": "accept, origin, authorization"}; //you probably don't need this line.  This lets me connect to my server on a different domain
//    $http.defaults.headers.common['Authorization'] = 'Basic ' + Base64.encode('admin' + ':' + 'password');
            
//            $http.defaults.headers.common.Authorization = 'Basic '+'user:hari';
//            $http.get(url + userId)
//                    .success(function(d) {
//                        user = d;
////                        console.log(d);
//                        deffered.resolve();
//                    });
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
         getGroupObj: function() {
            return groupObj;
        },
         addGroup: function(Group) {
//            user.groups[0].groups.push(Group);
            return $http.post(url + currUserId + "/group/", Group);
        },
        deleteGroup: function(groupId) {
            return $http.delete(url + currUserId + "/group/"+groupId);
        },
        editGroup: function(groupId, Group) {
            return $http.put(url + currUserId + "/group/"+groupId, Group);
        },
          getFriendObj: function() {
            return friendObj;
        },
        authenticateAndGetUserFromHttp: function(email,password) {
            
            var encodedAuth = Base64.encode(email + ':' + password);
            var serverResponseCode="";
 return $http({
     method: 'GET', 
     url: url+"6", 
     headers: {'Authorization': 'Basic ' + encodedAuth}
 
            });
//            return serverResponseCode;
        },
        setUser: function(user_received) {
            user=angular.copy(user_received);
        }
    };
});


billRive.factory('Base64', function() {
    var keyStr = 'ABCDEFGHIJKLMNOP' +
        'QRSTUVWXYZabcdef' +
        'ghijklmnopqrstuv' +
        'wxyz0123456789+/' +
        '=';
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
 
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
 
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
 
                output = output +
                    keyStr.charAt(enc1) +
                    keyStr.charAt(enc2) +
                    keyStr.charAt(enc3) +
                    keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);
 
            return output;
        },
 
        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
 
            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));
 
                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;
 
                output = output + String.fromCharCode(chr1);
 
                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }
 
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
 
            } while (i < input.length);
 
            return output;
        }
    };
});