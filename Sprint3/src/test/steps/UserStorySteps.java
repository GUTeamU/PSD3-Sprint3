package test.steps;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import users.Admin;
import users.Lecturer;
import users.Student;
import users.Tutor;
import users.Users;
import dbDriver.dbDriver;

public class UserStorySteps {

	private Users user;
	private dbDriver db = new dbDriver();
	private Student stud;
	private Admin  ad;
	private Lecturer lec;
	
	private String course;
	private int session;
	private int time;
	private String studentID;
	private int capacity;
	private String startTime;
	private int duration;
	private int day;
	private String room;
	
	private int numCourse = 0;
	private int numSession = 0;
	private int numUsers  = 0;
	private int numSlots = 0;

	private ResultSet returnValue;
	private int sizeBefore;
	
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
		if (user instanceof Lecturer ) {//make sure it is an instance of the child class before casting
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
		if (user instanceof Student) {//make sure it is an instance of the child class before casting
			returnValue = ((Student) user).checkCompulsorySessions(studentID);
			try{
				returnValue.last();
				int count = returnValue.getRow();
				returnValue.first();
				for(int i=0; i<count; i++){
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			returnValue = ((Student) user).checkCompulsorySessions(studentID);
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
	public void checkSessionExistence() throws Exception{
//		throw new Exception("Before DB");
		returnValue = db.selectCourseSessions(course);
//		throw new Exception("After DB: ");
		try{
			returnValue.last();
			throw new Exception("Return Last");
//			assertThat(returnValue.getRow(), equalTo(sizeBefore+1));
//			throw new Exception("After Assertion");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Then("the session is recurring")
	public void checkSessionRecurring(){
		returnValue = db.selectSession(session);
		int value = 0;
		try{
			value = returnValue.getInt("recurring");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertThat(value, equalTo(1));
	}

	@Then("I see the details of every session")
	public void checkDetailsExistence(){
		int columns = 0;
		int rows = -1;
		try{
			ResultSetMetaData rsmd = returnValue.getMetaData();
			columns = rsmd.getColumnCount();
			returnValue.last();
			rows = returnValue.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertThat(columns, equalTo(5));
		assertThat(rows, greaterThanOrEqualTo(0));
	}

	@Then("the slots are booked")
	public void checkSlotBooked(){
		try {
			returnValue.last();
			assertThat(returnValue.getRow(), equalTo(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Then("the system checks")
	public void checkCompulsory(){
		
	}

	@Then("the system the system creates a timeslot")
	public void checkAssignment(){
		returnValue = db.checkTimeSlot(capacity, startTime, duration, day, room);
		try{
			returnValue.last();
			assertThat(returnValue.getRow(), greaterThan(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	//Non-functional requirements
	

	@Given("a system")
	public void aSystem(dbDriver db){
		this.db = db;				
	}

	@When("a student logs in")
	public void StudentLogin(){
		stud = new Student(db);
	}

	@When("an admin logs in")
	public void AdminLogin(){
		ad = new Admin(db);

	} 

	@When("a lecturer logs in")
	public void LecturerLogin(){
		lec = new Lecturer(db);
	} 

	@Then("Then the student interface is shown")
	public void studentAccess(){
		assertTrue(stud instanceof Student);
	}

	@Then("Then the admin interface is shown")
	public void adminAccess(){
		assertTrue(ad instanceof Admin);
	}

	@Then("Then the lecturer interface is shown")
	public void lecturerAccess(){
		assertTrue(lec instanceof Lecturer);
	}

	
	//Performance 0
	@When("the system supports more than $courseNumb courses")
	public void numberOfCourses(int courseNumb){
		numCourse=db.courseNum(courseNumb);
	}

	@Then("The system will support more than $courseN courses")
	public void courseNumSupport(int courseN){
		assertThat(courseN,greaterThan(100));
	}

	@When("total users are over $totalUsers")
	public void countUsers(int totalUsers){
		numUsers = db.userNumber(totalUsers);
	}

	@Then("system can support more than $total users")
	public void usersSupported(int total){
		assertThat(total,greaterThan(1000));
	}

	
}
