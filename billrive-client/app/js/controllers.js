billRive.controller('billController', function($scope, billService) {
  
  $scope.bills= billService.getBills();
  
  $scope.friends=billService.getFriends();
  $scope.groups=billService.getGroups();
  $scope.payers=billService.getPayers();
$scope.bill=billService.getBill();
        
  
       $scope.addBill=function (){
          
     };
     
     $scope.setBillGroup= function(){
     //console.log("hello");
         $scope.bill.notes="group selected is"+$scope.bill.groupId;
         
       
     };
    
  
//    billService.getBills(function(data) {
//     $scope.bills = data;
//     $scope.username ="Prashanth";
//    
//
//$scope.friends= [
//{name:'John Doe'},
//{name:'Kristen Stewart'},
//{name:'Trevor Pott'},
//{name:'Hilda Hess'},
//{name:'Gavin Mays'}
//];
//
//
//$scope.groups= [
//{name:'SLC Roommates'},
//{name:'Denver Old Buddies'},
//{name:'Ski Club'},
//{name:'Family'},
//{name:'India'}
//];
//
//     function addBill(){
//         
////         $scope.bills.put();
//     };
//     
//      function deleteBill(){
//         
//         
//     };
//     
//      function editBill(){
//         
//         
//     };
//  });
});

