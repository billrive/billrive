/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
billRive.factory('groupService',function($http,$q,$cookieStore){
    var url = 'http://localhost\:8080/billrive-service/group/';
     var deffered = $q.defer();
     var groupObj = {
        "id": null,
        "name": null,
        "description": null,
        "ownerId": null,
        "isActive": true
    };
    var group={};
    return {
        
          getGroups: function() {
            return group;
        },
    authenticateForHttp: function() {
            
       
//        authenticateAndGetUserFromHttp: function(email, password) {

       var encodedAuth = $cookieStore.get('authdata');
       if(encodedAuth===undefined)
                return null;
//        else
//            return true;
//            var serverResponseCode = "";
            return encodedAuth },    
        getGroupsFromHttp : function (userId){
                    var encodedAuth = this.authenticateForHttp();
                    console.log(' Encoded Auth '+ encodedAuth);
                    $http({
                            method: 'GET',
                            url: url + userId+'/groups/'
                            , headers: {'Authorization': 'Basic ' + encodedAuth}

                          }).success(function(data, status, headers, config) {
                        group = data;
//                        console.log(d);
                        deffered.resolve();
                        // this callback will be called asynchronously
                        // when the response is available
                    }).
                    error(function(data, status, headers, config) {

                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                    });
                 return deffered.promise;
        }
        
        
    };
    
});

