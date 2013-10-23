billRive.factory('billService',function($http){
   var factory = {};
   var user={};

    $http({ method: 'GET', url: 'http://localhost:8082/billrive-service/user/6' }).
  success(function (data, status, headers, config) {
    user=angular.copy(data.data);
  }).
  error(function (data, status, headers, config) {
    // ...
  });

  
  var bills = [];//angular.copy(this.user.groups[0].bills);//users;
//Bill Object Structure
var billObj={
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
   
   var billSimpleEntryObj={
        "billId": null,
        "itemDescription": null,
        "simpleUserIdAndLiableCost": [
        ],
        "itemDescriptionId": 2
    };
//billFinances Object Structure 

var simpleUserIdAndLiableCostObj={
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
{id:1,users:[1,2,3,4],name:'SLC Roommates', isActive:'true'},
{id:2,users:[1,2],name:'Denver Old Buddies', isActive:'false'},
{id:3,users:[2,3],name:'Ski Club', isActive:'true'},
{id:4,users:[2,5],name:'Family',isActive:'false'},
{id:5,users:[1,2,3,5],name:'India',isActive:'true'}
];

var groupFriendRel=[{groupId:'1',friendId:'5'}];


 factory.getBills=function(){
//   queryUser();
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
 
 
  factory.getUser=function(){
     return user;
 };
  factory.getBillSimpleEntryObj=function(){
     return billSimpleEntryObj;
 };
  factory.getSimpleUserIdAndLiableCostObj=function(){
     return simpleUserIdAndLiableCostObj;
 };
  
  

 return factory;
});