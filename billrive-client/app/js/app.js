'use strict';

var billRive = angular.module('billRive', ['ngRoute','restangular']);
//angular.module('billRive', ['restangular']);

//billRive.config(function(RestangularProvider) {
//    RestangularProvider.setBaseUrl('http://localhost:8080/billrive-service');
//
//});

billRive.config(function($httpProvider){
    $httpProvider.interceptors.push(function($rootScope, $location, $q){
        return {
      'request': function(request) {
        // if we're not logged-in to the AngularJS app, redirect to login page
        $rootScope.loggedIn = $rootScope.loggedIn || $rootScope.username;
        if (!$rootScope.loggedIn && $location.path() != '/login') {
          $location.path('/login');       
        }
        return request;
      },
      'responseError': function(rejection) {
        // if we're not logged-in to the web service, redirect to login page
        if (rejection.status === 401 && $location.path() != '/login') {
          $rootScope.loggedIn = false;
          $location.path('/login');
        }
        return $q.reject(rejection);         
      }
    };
    });
});