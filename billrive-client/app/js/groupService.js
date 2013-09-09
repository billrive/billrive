billRive.factory('groupService',function($http,billService){
   var factory = {};

var groups= [
{id:1,users:[1,2,3,4],name:'SLC Roommates', isActive:'true'},
{id:2,users:[1,2],name:'Denver Old Buddies', isActive:'false'},
{id:3,users:[2,3],name:'Ski Club', isActive:'true'},
{id:4,users:[2,5],name:'Family',isActive:'false'},
{id:5,users:[1,2,3,5],name:'India',isActive:'true'}
];
var user = billService.getUser();
var groups=angular.copy(user.groups);

 factory.groupBackendToFrontEndConv=function(){
     /*Conversion logic to convert variable groups (line 12) to denormalized structure
     like {id:1,users:[1,2,3,4],name:'SLC Roommates', isActive:'true'}
      **/
     var frontEndGroup=[];
     return frontEndGroup;
 
 
 };
 //This need to be reconsidered as we don't need to populate the whole group object when creating/editing a group.
  factory.groupFrontEndToBackendConv=function(){
      /*Reverse of groupBackendToFrontEndConv method
      **/
     return groups;
 
 
 };
 
 return factory;
});