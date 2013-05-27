billRive.controller('billController', function($scope, billService) {
  billService.getBills(function(data) {
     $scope.bills = data;
  });
});