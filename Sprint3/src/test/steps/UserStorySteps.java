package test.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
			((Lecturer) user).getCourseSessionDetails(course);
		}
	}

	@When ("I want to book a slot for each session for the course")
	public void bookSession(){
		
	}

	@When ("I want to check if I have signed up for all compulsory sessions so that I don't fail the course.")
	public void checkCompulsorySessions(){
		
	}

	@When ("I want to create a timetable slot for a session so that rooms can be assigned to slots.")
	public void addTimeslot(){
		
	}

	
	@When("the $modeName mode is selected")
	public void modeIsSelected(String modeName){
		
		currentMode = 
			Mode.valueOf(modeName.toUpperCase());
				
		microwaveOven.setCurrentMode(currentMode);
	}
	
	@When("a $size chicken is selected")
	public void cookingItemName(String size)
		throws CookeryException{

		currentItem = FoodItemFactory.createChicken(size);

		microwaveOven.setCurrentFoodItem(currentItem);

	}
	
	@Then("cooking time is $expected minutes")
	public void cookingTimeIs(Integer expected)
		throws CookeryException{
		
		Integer actual =
			microwaveOven.getCalculatedTime();
						
		assertThat(actual, equalTo(expected));
	}
	
	@When("a chicken weighing $weight kg is roasted")
	public void aFoodItemWeighingKilosIsRoasted(Double weightInKilograms){
		
		currentItem = FoodItemFactory.createChicken(weightInKilograms);
		
		oven.roast(currentItem);
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
