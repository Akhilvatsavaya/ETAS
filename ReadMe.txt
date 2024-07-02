This ReadMe file contains sample JSON formats that can be used in the requestbody for post and put requests for the REST API calls

Employees

--Add a new employee
-> POST "/employee"

{
    "fullName": "full_name",
    "designation": "driver", 						//Employee or Driver
    "joiningDate": "2024-01-30",  					//Date Format - YYYY-MM-DD
    "email": "name@yantranet.com", 
    "phone": "1234547890",
    "address": "Long Beach, CA"
}




--Update an existing employee
-> PUT "/employee"

{
    "id": id,
    "fullName": "full_name",
    "designation": "driver",
    "joiningDate": "2024-01-30",
    "email": "name@yantranet.com", 
    "phone": "1234547890",
    "address": "Huntington, CA"
}





Cabs

--Add new Cab
-> POST "/cabs"

{
    "registrationNumber": "CA129",
    "driverId": 153,
    "cabStatus": "UNAVAILABLE",
    "comments": "NEW CAR",
    "vacancy": 0
}





--Update an existing cab
-> PUT "/cabs"

{
    "cabId": 102,
    "registrationNumber": "CA653",
    "driverId": 2,
    "cabStatus": "UNAVAILABLE",
    "comments": "NEW CAR",
    "vacancy": 0
}





--Set cab status to 'AVAILABLE'
-> PUT "/cabs/{id}/available"

This call sets the cab status to 'AVAILABLE' and increases the vacancy by 1.
Cab vacancy cannot be more than 4.




--Set cab status to 'UNAVAILABLE'
-> PUT "/cabs/{id}/unavailable"

This call sets the cab status to 'UNAVAILABLE' and changes the vacancy to 0.




Bookings

--Request a Cab
-> POST "/request"

{
    "sourceLocation": "Visakhapatnam",
    "dateTimeOfJourney": "2024-07-02T22:30:00",
    "employeeId": 1
}







