billRive.controller('BillController',ListBillsController);


function ListBillsController($scope) {
  $scope.todos = [
    {text:'learn angular', done:true},
    {text:'build an angular app', done:false}];


$scope.bills=
     [
        {
            "id": 1,
            "title": "Walmart",
            "date": {
                "year": 2013,
                "dayOfMonth": 3,
                "era": 1,
                "dayOfWeek": 7,
                "dayOfYear": 34,
                "weekyear": 2013,
                "yearOfEra": 2013,
                "hourOfDay": 1,
                "weekOfWeekyear": 5,
                "millisOfDay": 3660000,
                "minuteOfDay": 61,
                "yearOfCentury": 13,
                "millisOfSecond": 0,
                "monthOfYear": 2,
                "minuteOfHour": 1,
                "secondOfMinute": 0,
                "centuryOfEra": 20,
                "secondOfDay": 3660,
                "millis": 1359878460000,
                "zone": {
                    "uncachedZone": {
                        "cachable": true,
                        "fixed": false,
                        "id": "America/Denver"
                    },
                    "fixed": false,
                    "id": "America/Denver"
                },
                "chronology": {
                    "zone": {
                        "uncachedZone": {
                            "cachable": true,
                            "fixed": false,
                            "id": "America/Denver"
                        },
                        "fixed": false,
                        "id": "America/Denver"
                    }
                },
                "beforeNow": true,
                "afterNow": false,
                "equalNow": false
            },
            "billPayerId": 2,
            "notes": "Sample Notes",
            "billFinances": {
                "billPayerId": 1,
                "billItemEntry": [
                    {
                        "itemDescriptionId": 1,
                        "itemDescription": "Canola Oil",
                        "userIdAndLiableCost": [
                            {
                                "userId": 2,
                                "liableCost": 10
                            },
                            {
                                "userId": 3,
                                "liableCost": 20
                            }
                        ]
                    },
                    {
                        "itemDescriptionId": 2,
                        "itemDescription": "Taco Bell",
                        "userIdAndLiableCost": [
                            {
                                "userId": 4,
                                "liableCost": 50
                            },
                            {
                                "userId": 5,
                                "liableCost": 40
                            }
                        ]
                    }
                ],
                "billTotal": 30
            },
            "groupId": 2
        },
        {
            "id": 2,
            "title": "Costco",
            "date": {
                "year": 2014,
                "dayOfMonth": 3,
                "era": 1,
                "dayOfWeek": 1,
                "dayOfYear": 34,
                "weekyear": 2014,
                "yearOfEra": 2014,
                "hourOfDay": 1,
                "weekOfWeekyear": 6,
                "millisOfDay": 3660000,
                "minuteOfDay": 61,
                "yearOfCentury": 14,
                "millisOfSecond": 0,
                "monthOfYear": 2,
                "minuteOfHour": 1,
                "secondOfMinute": 0,
                "centuryOfEra": 20,
                "secondOfDay": 3660,
                "millis": 1391414460000,
                "zone": {
                    "uncachedZone": {
                        "cachable": true,
                        "fixed": false,
                        "id": "America/Denver"
                    },
                    "fixed": false,
                    "id": "America/Denver"
                },
                "chronology": {
                    "zone": {
                        "uncachedZone": {
                            "cachable": true,
                            "fixed": false,
                            "id": "America/Denver"
                        },
                        "fixed": false,
                        "id": "America/Denver"
                    }
                },
                "beforeNow": false,
                "afterNow": true,
                "equalNow": false
            },
            "billPayerId": 2,
            "notes": "Second sample Notes",
            "billFinances": {
                "billPayerId": 2,
                "billItemEntry": [],
                "billTotal": 90
            },
            "groupId": 2
        }
    ];

}