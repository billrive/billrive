billRive.factory('userService', function($http,Restangular) {
    var user = {};
//  var factory = {};
//  var user=null;//= Restangular.one("user",6).get();
//  
//     
//   factory.getUser=function(){
//      Restangular.one("user", 6).get().then(function(user_) {
//       user = user_;
//        return user;
//      });
//     
// };
// 
//
// return factory;
    var userService = {
    async: function() {
      // $http returns a promise, which has a then function, which also returns a promise
      var promise = $http.get('http://localhost:8080/billrive-service/user/6').then(function (response) {
        // The then function here is an opportunity to modify the response
//        console.log(response);
        // The return value gets picked up by the then in the controller.
//        return response;
        user = response;
        return response;
      });
      // Return the promise to the controller
      return promise;
    }
  };
  
  return userService;
});