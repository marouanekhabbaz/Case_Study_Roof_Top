### To add a new driver send a get request to the below endpoint, and add the following parameters :
#### endpoint: /addDriver 
#### parameters :

* Name: should be a string.
* phoneNr: should be unique and should be long.

As example: http://localhost:8080/addDriver?name=driver1&phoneNbr=123456789



### To place an order send a get request to the following endpoint, and add parameters as follows:
#### Endpoint: /placeOrder
#### Parameters : 
* time : represent order time, it should be a number.
* travelDuration : For travel time. it should be a number.
* custmerName :  should be a String.
* CustomerPhone : should a long. 

As example http://localhost:8080/placeOrder?time=10&travelDuration=6&customerName=marouane&customerPhone=987654321
