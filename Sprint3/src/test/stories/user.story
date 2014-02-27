Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci
When importing the sessions
Then the sessions will import correctly

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci
When I add a session
Then the session is made

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci
And a session, Lab
When I specify a session is recurring
Then the session is recurring

Scenario: As a lecturer
Given a user, lecturer
And a course, CompSci
And a session, Lab
When I want to see details
Then I see the details of every session


Scenario: As a student
Given a student
And a course, CompSci
When I want to book a slot for each session for the course
Then the slots are booked

Scenario: As a student
Given a student
And a course, CompSci
When I want to check if I have signed up for all compulsory sessions so that I don't fail the course.
Then the system checks

Scenario: As an administrator
Given an administrator
And a session, Lab
When I want to create a timetable slot for a session so that rooms can be assigned to slots.
Then the system assigns the sessions