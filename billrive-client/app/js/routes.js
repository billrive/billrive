billRive.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/listBills', {templateUrl: 'partials/listBills.html', controller: 'billController'});
    $routeProvider.when('/addBill', {templateUrl: 'partials/addBill.html', controller: 'billController'});
    $routeProvider.when('/listFriends', {templateUrl: 'partials/listFriends.html', controller: 'billController'});
    $routeProvider.otherwise({redirectTo: '/listBills'});
  }]);
  
  billRive
  .config(function($httpProvider){
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});