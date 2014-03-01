billRive.controller('userCtrl', function(univService,$scope) {
  $scope.isUserLoggedIn = univService.getIsUserLoggedIn();

});

