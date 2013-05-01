       angular.module('project', []).
    config(function($routeProvider) {
    $routeProvider.
    when('/login', {controller:ShowLogin, templateUrl:'login.html'}).
    when('/dashboard', {controller:DashboardCtrl, templateUrl:'dashboard.html'}).
    when('/signup', {controller:SignupCtrl, templateUrl:'signup.html'}).
    otherwise({redirectTo:'/login'});
    });



    function ShowLogin($scope) {
    $scope.username = "admin";
    
    }

      function SignupCtrl($scope) {
    $scope.userName = "admin";
    
    }

      function DashboardCtrl($scope) {
      $scope.userName = "admin";
      $scope.user={"Active":true,"Address":"101 Downtoen","Alias":"Doe","Cell":"801-000-0000","City":"Salt Lake City","country":"USA","CommunityNickName":"jDoe","CompanyName":"Fantasy World","Department":"Engineering","Division":"IT","EMail":"jdoe@gmail.com","EmployeeNumber":"1B0004","Language":"English","Locale":"en_US","Name":"John Doe","Phone":"801-111-1111","Role":"Engineer","TimeZone":"MST","Username":"jdoe@gmail.com","State":"Utah","Title":"Software Engineer","zip":"84101","CreatedBy":"jdoe@gmail.com","ObjectName":"USER","LastModifiedBy":"jdoe@gmail.com","Owner":"jdoe@gmail.com","CreationDate":"2013-04-01 00-00-00","LastModifiedDate":"2013-04-01 00-00-00"};
    
    }



        function Authenticate($scope, $location) {
            $location.path('/dashboard');
   
    if($scope.userName=="admin" && $scope.password=="admin")
    {
         
    }
    
    }