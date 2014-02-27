package test.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.sql.ResultSet;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import users.Admin;
import users.Lecturer;
import users.Student;
import users.Tutor;
import users.Users;
import dbDriver.DatabaseInterface;
import dbDriver.dbDriver;

public class UserStorySteps {

	private Users user;
	private dbDriver db = new dbDriver();
	
	private String course;
	private int session;
	private int time;
	private String studentID;
	private int capacity;
	private String startTime;
	private int duration;
	private int day;
	private String room;

	private ResultSet returnValue;
	
	@Given("a user, $user")
	public void aUser(String user){
		if(user.equalsIgnoreCase("User")){
			;
		}else if(user.equalsIgnoreCase("Admin")){
			this.user = new Admin(db);
		}else if(user.equalsIgnoreCase("Lecturer")){
			this.user = new Lecturer(db);
		}else if(user.equalsIgnoreCase("Student")){
			this.user = new Student(db);
		}else if(user.equalsIgnoreCase("Tutor")){
			this.user = new Tutor(db);
		}else{
			// Error
		}
	}
	
	@Given("a course, $course")
	public void aCourse(String course){
		this.course = course;
	}
	
	@Given("a session, $session")
	public void aSession(int session){
		this.session = session;
	}	
	
	@Given("a time, $time")
	public void aTime(int time){
		this.time = time;
	}
	
	@Given("a student, $student")
	public void aStudent(String student){
		this.studentID = student;
	}
	
	@Given("a capacity, $capacity")
	public void aCapacity(int capacity){
		this.capacity = capacity;
	}
	
	@Given("a start time, $startTime")
	public void aStartTime(String startTime){
		this.startTime = startTime;
	}
	
	@Given("a duration, $duration")
	public void aDuration(int duration){
		this.duration = duration;
	}
	
	@Given("a day, $day")
	public void aDay(int day){
		this.day = day;
	}

	@Given("a room, $room")
	public void aRoom(String room){
		this.room = room;
	}
	
	@When ("importing the sessions")
	public void importSessions(){
		
	}

	@When ("I add a session")
	public void addSession(){
		if (user instanceof Lecturer) {//make sure it is an instance of the child class before casting
			((Lecturer) user).addSession(course, false, false);
		}
	}

	@When ("I specify a session is recurring")
	public void makeSessionRecurring(){
		if (user instanceof Lecturer) {//make sure it is an instance of the child class before casting
			((Lecturer) user).makeSessionRecurring(session);
		}
	}

	@When ("I want to see details")
	public void getCourseSessionDetails(){
		if (user instanceof Lecturer) {//make sure it is an instance of the child class before casting
			returnValue = ((Lecturer) user).getCourseSessionDetails(course);
		}
	}

	@When ("I want to book a slot for each session for the course")
	public void bookSession(){
		if (user instanceof Admin) {//make sure it is an instance of the child class before casting
			((Admin) user).bookSession(session, time);
		}
	}

	@When ("I want to check if I have signed up for all compulsory sessions so that I don't fail the course.")
	public void checkCompulsorySessions(){
		if (user instanceof Student) {//make sure it is an instance of the child class before casting
			((Student) user).checkCompulsorySessions(studentID);
		}
	}

	@When ("I want to create a timetable slot for a session so that rooms can be assigned to slots.")
	public void addTimeslot(){
		if (user instanceof Admin) {//make sure it is an instance of the child class before casting
			((Admin) user).addTimeslot(capacity, startTime, duration, day, room);
		}
	}
	
	
	@Then("the sessions will import correctly")
	public void sessionImport(){
		
	}

	@Then("the session is made")
	public void checkSessionExistence(){
		
	}

	@Then("the session is recurring")
	public void checkSessionRecurring(){
		
	}

	@Then("I see the details of every session")
	public void checkDetailsExistence(){
		
	}

	@Then("the slots are booked")
	public void checkSlotBooked(){
		
	}

	@Then("the system checks")
	public void checkCompulsory(){
		
	}

	@Then("the system assigns the sessions to the timeslot")
	public void checkAssignment(){
		
	}

	
	@Then("cooking time is $expected minutes")
	public void cookingTimeIs(Integer expected)
		throws CookeryException{
		
		Integer actual =
			microwaveOven.getCalculatedTime();
						
		assertThat(actual, equalTo(expected));
	}
	
	@Then("oven temperature is $expected degrees celsius")
	public void ovenTemperatureIs(Integer expected){
		Integer actual = oven.getTemperatureCelsius();
		
		assertThat(actual, equalTo(expected));
	}
	
	@Then("roasting time is $expected minutes")
	public void roastingTimeIs(Integer expected){
		Integer actual = oven.getRoastingTime();
		
		assertThat(actual, equalTo(expected));
	}
}
