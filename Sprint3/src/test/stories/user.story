Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci203
When importing the sessions
Then the sessions will import correctly

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci203
When I add a session
Then the session is made

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci203
And a session, 1
When I specify a session is recurring
Then the session is recurring

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci203
And a session, 1
When I want to see details
Then I see the details of every session

Scenario: As a student
Given a user, student
And a course, CompSci203
When I want to book a slot for each session for the course
Then the slots are booked

Scenario: As a student
Given a user, student
And a course, CompSci203
When I want to check if I have signed up for all compulsory sessions so that I don't fail the course.
Then the system checks

Scenario: As an administrator
Given an administrator
And a session, 1
When I want to create a timetable slot for a session so that rooms can be assigned to slots.
Then the system creates a timeslot


Scenario: As a user
Given a student
When a student logs in
Then the student interface is shown

Scenario: As a user
Given an admin
When an admin logs in
Then the admin interface is shown

Scenario: As a user
Given a lecturer
When a lecturer logs in
Then the lecturer interface is shown

Scenario: As a user
Given a user
When logging into the system
I want to authenticate myself using the MyCampus single sign-on service

Scenario:
Given a list of courses
When up to 10 sessions are added
Then students should be able to enroll

Scenario:
Given a system
When the system supports more than 100 courses
The system will support more than 100 courses

Scenario: System needs to handle more than 1000 users
Given a system
When total users are over 1000
Then the system can support over 1000 users

Scenario: System needs to support over 20 timetable slots
Given a System
When session 1 can support 20 timeslots
Then the system can support more than 20 timeslots

Scenario: As an admin
Given an admin
When 
I want to check that there are no timetable slot clashes between courses so that students are able to complete the course.