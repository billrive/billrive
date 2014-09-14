'use strict';

/* Filters */

angular.module('billRive.filters', []).
  filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    }
  }]);
//angular.module('billRive.filters', []).
//  filter('ActiveGroupFilter', ['version', function(version) {
//    return function(text) {
//      return String(text).replace(/\%VERSION\%/mg, version);
//    }
//  }]);
