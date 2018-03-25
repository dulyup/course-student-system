# course-student-system

## Techniques
* Database: DynamoDB
* Microservice: Lambda, SNS
* Storage: S3, 
* Deployment: ElasticBeanStalk
* Security: IAM
* Backend: Java, Maven, Tomcat

## Features
* Create a topic with topic ARN everytime a new course created.
* Students subscribe the topic automatically once registered the course, and unsubscribe once drop the course.
* Lambda is responsible for monitoring the Announcement table, everytime a new annoucement posted, all enrolled students get the notification via email.

## RESTful API Implemented:
**For Program:**

| URI         | REQUEST | NOTE |
| :---        | :----   | :----   |
| ../programs | GET, POST | 
| ../programs/{programId} | GET, PUT, DELETE | 
| ../programs/courses | GET | 
| ../programs/courses | POST | Add Course for Program|
| ../programs/courses/{courseId} | DELETE | Remove Course from Program|
| ../programs/students | GET |

**For Course:**

| URI         | REQUEST | 
| :---        | :----   |
| ../courses | GET, POST | 
| ../courses/{courseId} | GET, PUT, DELETE | 
| ../courses/students | GET |
| ../courses/lectures | GET |

**For Announcement:**

| URI         | REQUEST | 
| :---        | :----   |
| ../courses/{courseId} | POST  | 
| ../courses/{courseId}/{anId} | DELETE | 


**For Student:**

| URI         | REQUEST | NOTE |
| :---        | :----   | :----    |
| ../students | GET, POST | 
| ../student/{studentId} | GET, PUT, DELETE | 
| ../courses | GET, POST |  
| ../student/courses | GET |
| ../student/{courseId} | PUT, DELETE | Register/Drop Course |

**For Lecture:**

| URI         | REQUEST | 
| :---        | :----   |
| ../lectures | GET, POST | 
| ../lectures/{lectureId} | GET, PUT, DELETE | 
