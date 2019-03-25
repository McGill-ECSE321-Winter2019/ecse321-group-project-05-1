# ECSE321 Project Group 5

## Table of Contents
* [About](#about)
* [Technical Issues](#technical-issues)
* [Teamwork Report](#teamwork-report)
* [File Location](#file-location)
* [Front End Explanation](#front-end-explanation)



## About
The Co-operator is a co-op management tool intregrating features from both myCourses and myFuture. Group 5 mainly focuses on developing from the student viewpoint. Keeping this in mind, the third deliverable includes: 

1. Architecture Modelling
2. Implementation of Web Frontend
3. Integration of Web Frontend with Backend Services
4. Build System
5. Documentation

Tools that were used for this Deliverable include: Gradle, Heroku, Postman, Travis CI, Heroku PostgreSQL, Vue.js, HTML, CSS, Javascript

## Technical Issues
- Trouble persisting data into the Heroku database
- Issues styling the UI 
- We were able to integrate with the POST methods but not the GET methods

## Teamwork Report
### Deliverable 1

|Team member's name|Total hours|Responsibility          |
|------------------|-----------|----------------------- |
|Salman            |   20 hours|Persistence layer and JUnit Testing |
|Tushar            |   19 hours|User Case Diagrams, UML Diagram |
|Archit            |   20 hours|UML Diagram, Heroku Deployment and JUnit testing         |
|Kathy             |   17 hours|User Case Diagrams, Documentation and Project Wiki        |
|Mert              |   18 hours|UML Diagram and Requirements Model                        |

### Deliverable 2

|Team member's name|Total hours|Responsibility          |
|------------------|-----------|----------------------- |
|Salman            |   32 hours|Model redesign, Persistence, REST API, Database Testing  |
|Tushar            |   16 hours|Documentation & Testing |
|Archit            |   40 hours|New UML, Persistence, JUnit Testing, REST, Travis CI |
|Kathy             |   17 hours|Documentation & Project Wiki  |
|Mert              |   17 hours|Documentation & Software Quality Assurance Report         |

### Deliverable 3

|Team member's name|Total hours|Responsibility          |
|------------------|-----------|----------------------- |
|Salman            |    hours|Integation of Frontend with Backend  |
|Tushar            |    hours|Frontend Implementation |
|Archit            |    hours|Integration of Frontend with Backend  |
|Kathy             |   17 hours|Documentation & Project Wiki  |
|Mert              |   17 hours|Architecture Model & Documentation         |

## File Location 
- Link to our REST controller class are included in the Backend folder under file controller
- Link to our BackEnd Heroku: https://cryptic-coast-32220.herokuapp.com
- Link to our FrontEnd Heroku: https://sleepy-anchorage-13805.herokuapp.com Unfortunately not deployed correctly :-( 
- Link to our deliverable 3 Project Report:https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-05-1/wiki/Project-Report-Deliverable-3
- Link to our Test Report: https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-05-1/wiki/Software-Quality-Assurance-Report
- Our latest build runs perfectly fine on Travis. Continuous Integration is successful too. The latest version of the app (with BackEnd REST added) is available on the link above. Refer to Wiki documentation to see how to access those REST methods. 
- Link to our Architecture Model: https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-05-1/wiki/Architecture-Model

## Front End Explanation
 - As we were unable to deploy the heroku frontend app successfully, we had to run our application on the localhost. Our application runs
 perfectly fine on local host so please use **npm run dev** to initialize it. 
 - Since our frontend heroku app was not deployed, we were also unable to connect it to travis but the backend continous integration with travis works fine.
 - Please create a new student and coop before accessing initial/technical/evaluation report methods. 
 
