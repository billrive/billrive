billRive.controller('userCtrl', function( userService,$scope) {
  // Call the async method and then do stuff with what is returned inside our own then function
  userService.async().then(function(d) {
    $scope.user = d;
  });
});

