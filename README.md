# Cycle Ranting Service
## Spring boot project with APIs to create and rent cycles

Application allows onboarding cycle & customer and allow customers to rent and ride cycle.

*Note:* 
* Have added some exception handling for example. We can add more.
* Not added any JUnit tests as of now
* Not created db file to create schema as of now. For now it will be created automatically using JPA in H2 db

## Features

* Onboard new cycle
* Onboard new customer
* Rent a cycle
* Return a cycle

## Tech

* Spring boot
	* Spring web
	* Spring JPA
	* Spring scheduler
	* lombok
	* spring H2
* Database
	* H2 (In Memory DB)

## API Reference

#### Get all Cycles

```http
  GET /cycle
```

#### Onboard new cycle
```http
POST /cycle
```
Example
```
curl --location --request POST 'http://localhost:8081/cycle' \
--header 'Content-Type: application/json' \
--data-raw '{
    "brand": "Avon"
}'
```

#### Get All customers

```http
  GET /customers
```

#### Onboard new customer

```http
POST /customer
```

Example
```
curl --location --request POST 'http://localhost:8081/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Hitesh",
    "emailAddress": "haahuja121@gmail.com"
}'
```

#### Get All Rides

```http
GET /ride
```

#### Create ride

```http
POST /ride/customer/{customer_id}/cycle/{cycle_id}
```

Example
```
curl --location --request POST 'http://localhost:8081/ride/customer/1/cycle/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "startTime": "2022-07-28 08:05"
}'
```

#### Update Ride (Complete ride)

```http
PUT /ride/{ride_id}
```

Example
```
curl --location --request PUT 'http://localhost:8081/ride/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "endTime": "2022-07-28 09:55",
    "distanceTravelled": 5
}'
```

### Generate Report
*Note*: Temparory API to run as scheduler will be time based and run on particular time

```http
GET /report/generate
```

#### Get Report by type

```http
GET /report
```

| Parameter     | Type     | Description                           |
| :------------ | :------- | :------------------------------------ |
| `reportType`  | `string` | **Required**. Type of report to fetch |

*reportType*: DAY_WISE_HIGHEST_DISTANCE_TRAVELER, OVERALL_HIGHEST_DISTANCE_TRAVELER, DAY_WISE_EARLY_TRAVELER, OVERALL_EARLY_TRAVELER, LONGEST_TIME_TRAVELER

Example
```
curl --location --request GET 'http://localhost:8081/report?reportType=OVERALL_EARLY_TRAVELER'
```