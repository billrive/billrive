'use strict';

/* Services */
billRive.factory('billService',function($http){
    
    return {
        
        getBills: function(callback){
            $http.get('http://localhost:8080/billrive-service/rest/2/bills/').success(callback);
        }
    };
});