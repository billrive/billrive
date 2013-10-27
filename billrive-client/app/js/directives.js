'use strict';

/* Directives */


angular.module('billRive.directives', []).
  directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
  }]);
  
  billRive.directive('convertDateToMilliSec', function() {
    return {
        restrict: 'A',
        require : 'ngModel',
        link: function(scope, element, attrs, ngModelCtrl) {
          element.datetimepicker({
            dateFormat:'dd/MM/yyyy hh:mm:ss',
            language: 'en-US'
          }).on('changeDate', function(e) {

            var outputDate = new Date(e.date);

           var n = outputDate.getTime();


           ngModelCtrl.$setViewValue(n);
            scope.$apply();
          });
        }
    };
});
