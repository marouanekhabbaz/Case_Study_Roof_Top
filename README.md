
### I explained my thought process in the following video:
https://www.loom.com/share/f2af7563d17c449caff422da96d1e730?sid=680b9556-4ac4-455c-8289-2a76f403da86 


### To add a new driver send a get request to the below endpoint , and add the following parameters :
#### endpoint: /addDriver 
#### parameters :

* name : should be a string.
* phoneNbr : should be unique and should be a long.

As example : http://localhost:8080/addDriver?name=driver1&phoneNbr=123456789



###To place an order send a get request to the following endpoint , and add parameters as following :
#### Endpoint: /placeOrder
#### Parameters : 
* time : represent order time , it should be a number.
* travelDuration : For travel time. it should be a number.
* custmerName :  should be a String.
* CustomerPhone : should a long. 

As example http://localhost:8080/placeOrder?time=10&travelDuration=6&customerName=marouane&customerPhone=987654321
