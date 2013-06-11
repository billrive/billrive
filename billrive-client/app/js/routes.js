billRive.config(['$routeProvider', function($routeProvider) {
//    $routeProvider.when('/', {templateUrl: 'partials/dashboard.html', controller: 'billController'});
    $routeProvider.when('/listBills', {templateUrl: 'partials/bills/list.html'});
    $routeProvider.when('/addBill', {templateUrl: 'partials/bills/add.html', controller: 'BillAddCtrl'});
    $routeProvider.when('/editBill', {templateUrl: 'partials/bills/edit.html', controller: 'BillAddCtrl'});
    $routeProvider.when('/listFriends', {templateUrl: 'partials/listFriends.html', controller: 'billController'});
    $routeProvider.otherwise({redirectTo: '/listBills'});
  }]);
  
  billRive
  .config(function($httpProvider){
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});