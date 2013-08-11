billRive.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/bills/list', {templateUrl: 'partials/bills/list.html'});
    $routeProvider.when('/bills/add', {templateUrl: 'partials/bills/add.html', controller: 'BillAddCtrl'});
    $routeProvider.when('/bills/edit/:id', {templateUrl: 'partials/bills/edit.html', controller: 'BillEditCtrl'});
    $routeProvider.when('/listFriends', {templateUrl: 'partials/listFriends.html', controller: 'billController'});
    $routeProvider.when('/groups/list',{templateUrl: 'partials/groups/list.html'})
    $routeProvider.when('/groups/add', {templateUrl: 'partials/groups/add.html', controller: 'GroupAddCtrl'});
    $routeProvider.when('/groups/edit/:id', {templateUrl: 'partials/groups/edit.html', controller: 'GroupEditCtrl'});
    $routeProvider.otherwise({redirectTo: '/bills/list'});
  }]);
  
  billRive
  .config(function($httpProvider){
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});
