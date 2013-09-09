billRive.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/bills/list', {templateUrl: 'partials/bills/list.html',controller: 'billCtrl'});
    $routeProvider.when('/bills/add', {templateUrl: 'partials/bills/add.html', controller: 'billCtrl'});
    $routeProvider.when('/bills/edit/:id', {templateUrl: 'partials/bills/edit.html', controller: 'BillEditCtrl'});
    $routeProvider.when('/bills/equalsplit', {templateUrl: 'partials/forms/EqualSplit.html', controller: 'EqualSplitCtrl'});
    $routeProvider.when('/listFriends', {templateUrl: 'partials/listFriends.html', controller: 'billCtrl'});
    $routeProvider.when('/groups/list',{templateUrl: 'partials/groups/list.html', controller: 'GroupListCtrl'})
    $routeProvider.when('/groups/add', {templateUrl: 'partials/groups/add.html', controller: 'GroupAddCtrl'});
    $routeProvider.when('/groups/edit/:id', {templateUrl: 'partials/groups/edit.html', controller: 'GroupEditCtrl'});

    $routeProvider.otherwise({redirectTo: '/bills/list'});
  }]);
  
  billRive
  .config(function($httpProvider){
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});
