billRive.config(['$routeProvider', function($routeProvider) {
//        $locationProvider.html5Mode(true);
//billRive.config(['$routeProvider', function($routeProvider,RestangularProvider) {
    $routeProvider.when('/bills/list', {templateUrl: 'partials/bills/list.html',controller: 'billCtrl'});
    $routeProvider.when('/bills/add', {templateUrl: 'partials/bills/add.html', controller: 'billCtrl'});
    $routeProvider.when('/bills/edit/:groupId/:billId', {templateUrl: 'partials/bills/edit.html', controller: 'billCtrl'});
    $routeProvider.when('/friends/list', {templateUrl: 'partials/friends/list', controller: 'friendCtrl'});
    $routeProvider.when('/friends/add', {templateUrl: 'partials/friends/add.html', controller: 'friendCtrl'});
    $routeProvider.when('/groups/list',{templateUrl: 'partials/groups/list.html', controller: 'groupCtrl'});
    $routeProvider.when('/groups/add', {templateUrl: 'partials/groups/add.html', controller: 'groupCtrl'});
    $routeProvider.when('/groups/edit/:id', {templateUrl: 'partials/groups/edit.html', controller: 'groupCtrl'});
    $routeProvider.when('/login', {templateUrl: 'partials/security/login.html', controller: 'loginCtrl'});
    
    $routeProvider.otherwise({redirectTo: '/bills/list'});
//    $routeProvider.otherwise({redirectTo: '/login'});

    //$routeProvider.otherwise({redirectTo: '/bills/list'});
//     RestangularProvider.setBaseUrl('http://localhost:8080/billrive-service');
     
  }]);
  
//  billRive
//  .config(function($httpProvider){
//    delete $httpProvider.defaults.headers.common['X-Requested-With'];
//});

//billRive.config(function(RestangularProvider) {
//    RestangularProvider.setBaseUrl('http://localhost:8080/billrive-service');
//
//    });
