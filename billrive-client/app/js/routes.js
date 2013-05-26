billRive.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/bills', {templateUrl: 'partials/listBills.html', controller: 'billController'});
    //$routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
    $routeProvider.otherwise({redirectTo: '/bills'});
  }]);
  
  billRive
  .config(function($httpProvider){
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});