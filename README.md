## Event Tracker Project
### Jeremy Botta

### Overview
- The application contains a single table MySQL table
- The data is accessed using Java entities created/annotated with JPA and Spring Boot. Users can create, update, and delete records through REST operations.
- Allows tracking of game enemies with names and health points.

### Technologies/Tools Used
* Java
* Gradle
* Spring Tool Suite
* Hibernate
* HTML
* CSS (Bootstrap)
* JavaScript and jQuery
* MySQL
* GitHub
* Amazon Web Services
* Spring Boot

### How to Run

http://18.217.143.254:8080/EventTracker/

OR

In Postman:

GET http://18.217.143.254:8080/EventTracker/api/enemies

Provides list of all enemies

GET http://18.217.143.254:8080/EventTracker/api/enemies/id

Replace id with a number to receive the individual JSON for the enemy with that
id

POST http://18.217.143.254:8080/EventTracker/api/enemies

Allows user to create a new Enemy

PATCH http://18.217.143.254:8080/EventTracker/api/enemies/id

Replace id with a number to update the Enemy with that id

PUT http://18.217.143.254:8080/EventTracker/api/enemies/id

Replace id with a number to replace the Enemy with that id

DELETE http://18.217.143.254:8080/EventTracker/api/enemies/id

Replace id with a number to delete the Enemy with that id

GET http://18.217.143.254:8080/EventTracker/api/enemies/avg

Provides the average hit points of all enemies


### Challenges and Lessons Learned
* Gained familiarity with Spring Bootstrap
* Improved knowledge of the layout of build.Gradle
* Practiced with AWS deployment
