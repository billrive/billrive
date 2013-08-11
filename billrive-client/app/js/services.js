billRive.factory('billService',function(){
   var factory = {};
var bills = [{
            "id": 1,
            "title": "Costco - Pharmacy",
            "date":"06/03/2013",
            "billPayerId": 2,
            "notes": "Sample Notes",
            "billFinances": {
                "billPayerId": 1,
                "billItemEntry": [
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Canola Oil",
                        "userIdAndLiableCost": [
                            {
                                "userId": 2,
                                "liableCost": 10
                            },
                            {
                                "userId": 3,
                                "liableCost": 20
                            }
                        ]
                    },
                    {
                        "itemDescriptionId": 2,
                        "itemDescription": "Taco Bell",
                        "userIdAndLiableCost": [
                            {
                                "userId": 4,
                                "liableCost": 50
                            },
                            {
                                "userId": 5,
                                "liableCost": 40
                            }
                        ]
                    }
                ],
                "billTotal": 35
            },
            "groupId": 2
        },
        {
            "id": 1,
            "title": "Farmers Market",
            "date":"06/01/2013",
            "billPayerId": 2,
            "notes": "Sample Notes",
            "billFinances": {
                "billPayerId": 1,
                "billItemEntry": [
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Canola Oil",
                        "userIdAndLiableCost": [
                            {
                                "userId": 2,
                                "liableCost": 10
                            },
                            {
                                "userId": 3,
                                "liableCost": 20
                            }
                        ]
                    },
                    {
                        "itemDescriptionId": 2,
                        "itemDescription": "Taco Bell",
                        "userIdAndLiableCost": [
                            {
                                "userId": 4,
                                "liableCost": 50
                            },
                            {
                                "userId": 5,
                                "liableCost": 40
                            }
                        ]
                    }
                ],
                "billTotal": 20
            },
            "groupId": 2
        },
        {
            "id": 1,
            "title": "Dining Out",
            "date":"05/28/2013",
            "billPayerId": 2,
            "notes": "Sample Notes",
            "billFinances": {
                "billPayerId": 1,
                "billItemEntry": [
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Canola Oil",
                        "userIdAndLiableCost": [
                            {
                                "userId": 2,
                                "liableCost": 10
                            },
                            {
                                "userId": 3,
                                "liableCost": 20
                            }
                        ]
                    },
                    {
                        "itemDescriptionId": 2,
                        "itemDescription": "Taco Bell",
                        "userIdAndLiableCost": [
                            {
                                "userId": 4,
                                "liableCost": 50
                            },
                            {
                                "userId": 5,
                                "liableCost": 40
                            }
                        ]
                    }
                ],
                "billTotal": 45
            },
            "groupId": 2
        },
        {
            "id": 1,
            "title": "Walmart",
            "date":"05/01/2013",
            "billPayerId": 2,
            "notes": "Sample Notes",
            "billFinances": {
                "billPayerId": 1,
                "billItemEntry": [
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Canola Oil",
                        "userIdAndLiableCost": [
                            {
                                "userId": 2,
                                "liableCost": 10
                            },
                            {
                                "userId": 3,
                                "liableCost": 20
                            }
                        ]
                    },
                    {
                        "itemDescriptionId": 2,
                        "itemDescription": "Taco Bell",
                        "userIdAndLiableCost": [
                            {
                                "userId": 4,
                                "liableCost": 50
                            },
                            {
                                "userId": 5,
                                "liableCost": 40
                            }
                        ]
                    }
                ],
                "billTotal": 35
            },
            "groupId": 2
        },
        {
            "id": 2,
            "title": "Costco",
            "date":"05/27/2013",
            "billPayerId": 2,
            "notes": "Second sample Notes",
            "billFinances": {
                "billPayerId": 2,
                "billItemEntry": [],
                "billTotal": 90
            },
            "groupId": 2
        }
    ]
;
//Bill Object Structure
var bill={
            "id": null,
            "title": "",
            "date": null,
            "billPayerId": null,
            "notes": "",
            "billFinances": {
                "billPayerId": null,
                "billSimpleTotals": 
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Simple",
                        "userIdAndLiableCost": []
                    }
                ,
                 "billItemEntry":[],
                "billTotal": null
            },
            "groupId": null
        };
    
//billFinances Object Structure  
var billFinances={
                "billPayerId": null,
                "billItemEntry": billItemEntry,
                "billTotal": null
            };
 
//billItemEntry Object Structure
var billItemEntry=
                    {
                        "itemDescriptionId": null,
                        "itemDescription": "",
                        "userIdAndLiableCost": userAndLiableCost
                    };
                
//userAndLiableCost Object Structure
var userAndLiableCost=
{userId:null,liableCost:null};

 var payers= [
{id:'1',name:'John Doe'},
{id:'2',name:'Kristen Stewart'},
{id:'3',name:'Trevor Pott'},
{id:'4',name:'Hilda Hess'},
{id:'5',name:'Gavin Mays'}
];

var friends= [
{id:'1',groups:[1,2,5],name:'John Doe'},
{id:'2',groups:[1,2,3,4,5],name:'Kris Stewart'},
{id:'3',groups:[1,3,5],name:'Trevor Potts'},
{id:'4',groups:[1],name:'Hilda Hess'},
{id:'5',groups:[4,5],name:'Gavin Mays'}
];


var groups= [
{id:'1',users:[1,2,3,4],name:'SLC Roommates'},
{id:'2',users:[1,2],name:'Denver Old Buddies'},
{id:'3',users:[2,3],name:'Ski Club'},
{id:'4',users:[2,5],name:'Family'},
{id:'5',users:[1,2,3,5],name:'India'}
];

var groupFriendRel=[{groupId:'1',friendId:'5'}];

 factory.getBills=function(){
     return bills;
 };
 
  factory.getPayers=function(){
     return payers;
 };
 
  factory.getFriends=function(){
     return friends;
 };
 
  factory.getGroups=function(){
     return groups;
 };
 
 
  factory.getBill=function(){
     return bill;
 };
 
  factory.getBillItemEntry=function(){
     return billItemEntry;
 };
 
  factory.getUserAndLiableCost=function(){
     return userAndLiableCost;
 };
 
  factory.getBillFinances=function(){
     return billFinances;
 };
 

 return factory;
});




//$scope.bills= billService.getBills();
//$scope.bills= [{"id":1,"title":"Walmart","date":{"year":2013,"dayOfMonth":3,"dayOfWeek":7,"era":1,"dayOfYear":34,"weekOfWeekyear":5,"minuteOfDay":61,"minuteOfHour":1,"monthOfYear":2,"millisOfSecond":0,"yearOfCentury":13,"secondOfDay":3660,"centuryOfEra":20,"millisOfDay":3660000,"secondOfMinute":0,"weekyear":2013,"hourOfDay":1,"yearOfEra":2013,"zone":{"uncachedZone":{"fixed":false,"cachable":true,"id":"America/Denver"},"fixed":false,"id":"America/Denver"},"millis":1359878460000,"chronology":{"zone":{"uncachedZone":{"fixed":false,"cachable":true,"id":"America/Denver"},"fixed":false,"id":"America/Denver"}},"beforeNow":true,"afterNow":false,"equalNow":false},"billPayerId":2,"notes":"Sample Notes","billFinances":{"billPayerId":1,"billItemEntry":[{"itemDescriptionId":1,"itemDescription":"Canola Oil","userIdAndLiableCost":[{"userId":2,"liableCost":10},{"userId":3,"liableCost":20}]},{"itemDescriptionId":2,"itemDescription":"Taco Bell","userIdAndLiableCost":[{"userId":4,"liableCost":50},{"userId":5,"liableCost":40}]}],"billTotal":30},"groupId":2},{"id":2,"title":"Costco","date":{"year":2014,"dayOfMonth":3,"dayOfWeek":1,"era":1,"dayOfYear":34,"weekOfWeekyear":6,"minuteOfDay":61,"minuteOfHour":1,"monthOfYear":2,"millisOfSecond":0,"yearOfCentury":14,"secondOfDay":3660,"centuryOfEra":20,"millisOfDay":3660000,"secondOfMinute":0,"weekyear":2014,"hourOfDay":1,"yearOfEra":2014,"zone":{"uncachedZone":{"fixed":false,"cachable":true,"id":"America/Denver"},"fixed":false,"id":"America/Denver"},"millis":1391414460000,"chronology":{"zone":{"uncachedZone":{"fixed":false,"cachable":true,"id":"America/Denver"},"fixed":false,"id":"America/Denver"}},"beforeNow":false,"afterNow":true,"equalNow":false},"billPayerId":2,"notes":"Second sample Notes","billFinances":{"billPayerId":2,"billItemEntry":[],"billTotal":90},"groupId":2},{"id":null,"title":"Farmers Market","date":"08/03/1986","billPayerId":"5","notes":"No Note","billFinances":{"billPayerId":null,"billSimpleTotals":{"itemDescriptionId":1,"itemDescription":"Simple","userIdAndLiableCost":[{"userId":2,"liableCost":"30","name":"Kris Stewart","enabled":true},{"userId":5,"liableCost":"30","name":"Gavin Mays","enabled":true}]},"billItemEntry":[],"billTotal":"60"},"groupId":"4"},{"id":null,"title":"Farmers Market","date":"08/03/1986","billPayerId":"5","notes":"No Note","billFinances":{"billPayerId":null,"billSimpleTotals":{"itemDescriptionId":1,"itemDescription":"Simple","userIdAndLiableCost":[{"userId":2,"liableCost":"30","name":"Kris Stewart","enabled":true},{"userId":5,"liableCost":"30","name":"Gavin Mays","enabled":true}]},"billItemEntry":[],"billTotal":"60"},"groupId":"4"}]
;
