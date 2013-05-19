billRive.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/bills', {templateUrl: 'partials/listBills.html', controller: 'BillController'});
    //$routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
    $routeProvider.otherwise({redirectTo: '/bills'});
  }]);