RealDef
======

RealDef is an open-source, geolocation aware, food truck look-up service. It's built on top of [Grails][1] and using [DataSF][2] and [Google API][3].


Requisites
----------

RealDef is written in Groovy/Grails and requires:

* A suitable JVM, version 6 or higher.
* Grails 2.0+, version 2.4.3 is used for development. (Recommend [gvm][4] to install Grails)
* A relational database, [PostgreSQL][5] is used by default.


Installation
------------

If you want to use personal user role and database, please skip the "setup local database" below, and modify Datasource.groovy under grails-app/conf.

## Setup local database
* `CREATE DATABASE "realdef"`
* `CREATE USER "realdef" superuser`
* `ALTER ROLE realdef WITH LOGIN`

## Populate the schema
Go to realDef/, and run `grails dbm-update`

## Run app
Go to realDef/, and run `grails run-app`

## Sync up data
Sync job will be triggered automatically every week to get latest food truck information from DataSF.
If this is your first time running this app, you can trigger it manually by
* Once the app is running, go to `http://localhost:8080/quartz/list`
* Click the green execute button


Using RealDef
--------------

Once the app is running.
Go to `http://localhost:8080/`, browser will ask you to provide the locations.

## Get near by food trucks
`http://localhost:8080/home/nearByFoodTruck`
```JSON
{
  "hasError": false,
  {
    "name": "Burger",
    "schedule": "http://...."
  },{
    "name": "Burger 2",
    "schedule": "http://...."
  }
}
```
```JSON
{
  "hasError": true,
  "error": "Something wrong..." // this will be real error messages
}
```

`http://localhost:8080/home/nearByFoodTruck?lat=12.3333&lnt=33.33333&radius=0.5`

#### lat, lnt, and radius are all optional, radius unit is miles


Work
--------------
`grails-app/controller`, `grails-app/service`, `grails-app/jobs`, `grails-app/test`, `grails-app/views`, and `grails-app/` are written by me. Also, some tweaks and settings under other directories as well.

## Design
Storing the data returned from the DataSF API, and only updating them periodically in order to improve the query performance.
As for the front-end part, a basic view is used to get locations through the browser.

## Testing
All methods in service are covered by unit tests.



[1]: https://grails.org/
[2]: https://data.sfgov.org/
[3]: https://developers.google.com/maps/
[4]: http://gvmtool.net/
[5]: http://www.postgresql.org
