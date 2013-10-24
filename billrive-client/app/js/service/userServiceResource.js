billRive.factory('userService', function($resource) {
   return $resource('http://localhost\\:8080/billrive-service/user:id',{
       id:'@_id.$oid'
   });
});
