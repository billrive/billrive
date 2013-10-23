billRive.factory('billFactory', function ($http) {
    var url = 'http://localhost\:8082/billrive-service/bill/';
            return {
                addBill: function (Bill) {
                    return $http.post(url, Bill);
                },
                deleteBill: function (Bill) {
                    return $http.delete(url + Bill.Id);
                },
                updateBill: function (Bill) {
                    return $http.put(url + Bill.Id, Bill);
                }
            };
        });