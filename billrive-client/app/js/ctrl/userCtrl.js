billRive.controller('userCtrl', function(Restangular,userService,$scope) {
  // Call the async method and then do stuff with what is returned inside our own then function
 
 $scope.examp="Hello world!";
        $scope.user = Restangular.one("user",6).get();
    
//    userService.async().then(function(d) {
//    $scope.user = d.data;
//  });
});

