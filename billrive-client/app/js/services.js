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
var billObj={
            "id": null,
            "title": "",
            "date": null,
            "billPayerId": null,
            "notes": "",
            "groupId": null,
            "billSimpleEntry": {
        "billId": null,
        "itemDescription": null,
        "itemDescriptionId": null,
        "simpleUserIdAndLiableCost": [
            
        ]        
    },                     
        "billItemEntry": [
        ]   
        };
    
//billFinances Object Structure 

var simpleUserIdAndLiableCostObj={
                "userId": null,
                "liableCost": null,
                "id": null,
                "billSimpleEntryId": null,
                "billItemEntryID": null
            };
   
var billItemEntryObj={
                    "userId": null,
                    "liableCost": null,
                    "billItemEntryID": null
                };
                
var billItemEntryObj={
            "id": null,
            "itemDescription": null,
            "billId": null,
            "itemDescriptionId": null,
            "userIdAndLiableCost": [
                
            ]
        };
            
var billFinancesObj={
                "billPayerId": null,
                "billItemEntry": billItemEntryObj,
                "billTotal": null
            };
 
//billItemEntry Object Structure
var billItemEntryObj=
                    {
                        "itemDescriptionId": null,
                        "itemDescription": "",
                        "userIdAndLiableCost": userAndLiableCost
                    };
                
//userAndLiableCost Object Structure
var userAndLiableCost=
{userId:null,liableCost:null};

 var payers= [
{id:1,name:'John Doe'},
{id:2,name:'Kristen Stewart'},
{id:3,name:'Trevor Pott'},
{id:4,name:'Hilda Hess'},
{id:5,name:'Gavin Mays'}
];

var friends= [
{id:1,groups:[1,2,5],name:'John Doe'},
{id:2,groups:[1,2,3,4,5],name:'Kris Stewart'},
{id:3,groups:[1,3,5],name:'Trevor Potts'},
{id:4,groups:[1],name:'Hilda Hess'},
{id:5,groups:[4,5],name:'Gavin Mays'}
];


var groups= [
{id:1,users:[1,2,3,4],name:'SLC Roommates'},
{id:2,users:[1,2],name:'Denver Old Buddies'},
{id:3,users:[2,3],name:'Ski Club'},
{id:4,users:[2,5],name:'Family'},
{id:5,users:[1,2,3,5],name:'India'}
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
 
 
  factory.getBillObj=function(){
     return billObj;
 };
 
  factory.billItemEntryObj=function(){
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



;
