# covid-tracker
The App Create a REST API app to expose service which can:

*Bulk add/modify daily/monthly cases of covid (with patient details like test date, test result, name, DOB and address)

*Bulk add/modify daily/monthly covid vaccination info(with patient details like vaccination date, second vaccination date, name, DOB and address)

*Get report of the total number of cases per day,per month, per year for every country (atleast have three countries) with pagination support

## Requirements
*java 11

*maven 3.6.3
## DataBase
The app use in-memory database 

## API
## covid cases
### create 
POST /covid-cases/

Application Type JSON

{
"testDate":"2021-08-08",
"testResult":"true",
"countryCode":"FR",
"patientFirstName":"AHMeeeD",
"patientLastName":"Ezzine",
"birthDate":"1998-05-13",
"patientAddress":"tunis"

}
### update 
PATCH /covid-cases/

Application Type JSON

{
id":1,
"testDate":"2021-08-08",
"testResult":"false",
"countryCode":"FR",
"patientFirstName":"AHMeeeD",
"patientLastName":"Ezzine",
"birthDate":"1998-05-13",
"patientAddress":"tunis"

}
### get daily report
GET /covid-cases/daily
Parameter: page (default=0)

### get monthly report
GET /covid-cases/monthly
Parameter: page (default=0)

## covid vaccination 
### create
POST /covid-vaccination/

Application Type JSON

{"doseNbr":1,
"countryCode":"TN",
"patientFirstName":"ABir",
"patientLastName":"Ezzine",
"birthDate":1612911600000,
"patientAddress":"Tunis"}
### update
PATCH /covid-vaccination/

Application Type JSON

{"id":1,"doseNbr":1,
"countryCode":"TN",
"patientFirstName":"ABir",
"patientLastName":"Ezzine",
"birthDate":1612911600000,
"patientAddress":"Tunis"}
