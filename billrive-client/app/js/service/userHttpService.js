billRive.factory('userFactory', function ($http) {
    var url = 'http://localhost\:8082/billrive-service/user/';
            return {
                getUsers: function () {
                    return $http.get(url);
                },
                 getUser: function (Id) {
                    return $http.get(url+Id);
                },
                addUser: function (User) {
                    return $http.post(url, User);
                },
                deleteUser: function (User) {
                    return $http.delete(url + User.Id);
                },
                updateUser: function (User) {
                    return $http.put(url + User.Id, User);
                }
            };
        });