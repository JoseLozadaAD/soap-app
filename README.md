# soap-app
Project using soap and spring boot

## Technologies
* Java 17
* Spring boot 3.1.5
* Maven 3.5+

## Run project
```
mvn clean
mvn compile
mvn spring-boot:run
```
## Postman
In postman import the following url `http://localhost:8080/ws/countries.wsdl`  
[Guide](https://www.baeldung.com/postman-soap-request)

### Requests
Get a country by its name
```
<?xml version="1.0" encoding="utf-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="www.assuresoft.com">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getCountryRequest>
            <gs:name>Poland</gs:name>
        </gs:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

Get all countries
```
<?xml version="1.0" encoding="utf-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="www.assuresoft.com">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getAllCountriesRequest>
        </gs:getAllCountriesRequest>
    </soapenv:Body>
</soapenv:Envelope>
```
