The purpose of the application is to serve as a convenient interface for managing a database containing all the actions performed from a certain phone

The requests to insert and remove calls from the database as well as to change the phone numbers of the contacts or add people to the blacklist can be done using http requests

The application was written using spring boot

The http requests are:

add new call:
http://localhost:8080/new-record 
Body
{
	"time":"07-07-10 13:00:00",
	"callType":"Incoming",
	"duration":"100",
	"phoneNumber":{""}
}

get calls by duration:
http://localhost:8080/get-by-duration/{duration}

get all the calls from specified number 
http://localhost:8080/get-by-number/{number}

update phone number:
http://localhost:8080/update-phone-number/0564210275/0564210276


