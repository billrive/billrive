/*User:

{
    "id": null,
    "fName": "John",
    "lName": "Doe",
    "mName": null,
    "title": null,
    "email": "john@doe.net",
    "groups": null
}

Bill:

{
   "id":null,
   "title":"",
   "billDate":null,
   "billPayerId":6,
   "notes":null,
   "billCreaterId":null,
   "groupId":3,
   "billTotal":null,
   "billSimpleEntry":{
      "billId":null,
      "itemDescription":null,
      "simpleUserIdAndLiableCost":[
         {
            "userId":6,
            "liableCost":"50",
            "id":null,
            "billSimpleEntryId":null,
            "user":{
               "id":null,
               "fName":"Prashanth",
               "lName":"Batchu"
            },
            "isActive":true
         },
         {
            "userId":7,
            "liableCost":"50",
            "id":null,
            "billSimpleEntryId":null,
            "user":{
               "id":null,
               "fName":"Jayanth",
               "lName":"Kondaveti"
            },
            "isActive":true
         },
         {
            "userId":8,
            "liableCost":"50",
            "id":null,
            "billSimpleEntryId":null,
            "user":{
               "id":null,
               "fName":"Karthik",
               "lName":"Kathari"
            },
            "isActive":true
         }
      ],
      "itemDescriptionId":2
   },
   "billItemEntry":[

   ],
   "userId":null
}

Bill without billsimpleentry

{
   "id":null,
   "title":"sams",
   "billDate":null,
   "billPayerId":6,
   "notes":null,
   "billCreaterId":null,
   "groupId":3,
   "billTotal":100,
   "billSimpleEntry":null,
   "billItemEntry":[

   ],
   "userId":null
}

/*
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('6', '3');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('7', '3');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('8', '3');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('6', '4');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('7', '4');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('6', '5');
INSERT INTO `billrivedb`.`usergroupmap` (`user_id`, `groups_id`) VALUES ('8', '5');
 
 
 drop database billrivedb;
create database billrivedb;
 *
 *
 **/