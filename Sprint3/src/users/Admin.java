package users;

import dbDriver.DatabaseInterface;

public class Admin extends Lecturer{

	
	public Admin(DatabaseInterface db) {
		super(db);
	}

	public void addTimeslot(String startTime, int duration, int day, String room){
		super.db.addTimeslot(startTime, duration, day, room);
	}
	
	public void addCourse(String courseID, String name){
		super.db.addCourse(courseID, name);
	}
	
	public void addStudent(String studentID, String name){
		super.db.addStudent(studentID, name);
	}
	
	public void signUpToTimeslot(int timeID, String studentID){
		super.db.signUpToTimeslot(timeID, studentID);
	}
	
	public void bookSession(int sessionID, int timeID){
		super.db.bookSession(sessionID, timeID);
	}
}

