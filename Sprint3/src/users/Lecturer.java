package users;

import java.sql.ResultSet;

import dbDriver.DatabaseInterface;

public class Lecturer extends Student{

	public Lecturer(DatabaseInterface db) {
		super(db);
	}

//	public boolean importMC(Course course){
//		//STUB
//	}

	public void addSession(String courseID, boolean recurring, boolean compulsory){
		super.db.addSession(courseID, recurring, compulsory);
	}

	public void makeSessionRecurring(int sessionID){
		super.db.makeSessionRecurring(sessionID);
	}

	public ResultSet getCourseSessionDetails(int courseID){
		return super.db.getCourseSessionDetails(courseID);
	}
}