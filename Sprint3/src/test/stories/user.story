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
Given a user
When a login is entered
Then the correct interface will be displayed

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
When enrollment begins
Then the system should be able to support 100 users at a time

Scenario:
Given 100 courses
When these are entered
Then the system will allow students to enroll

Scenario: 
Given 1000 users
When they are enrolled
Then they should be able to interact with it simultaneously

Scenario:
Given a session
When at least 20 timetable slots are scheduled
Then students should be able to enroll
