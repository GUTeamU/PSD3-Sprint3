package users;

import java.sql.ResultSet;

import dbDriver.DatabaseInterface;


public class Students extends Users{
	
	public Students(DatabaseInterface db) {
		super(db);
	}
	
	public void signUpToTimeslot(int timeID, String studentID){
		db.signUpToTimeslot(timeID, studentID);
	}
	
	public ResultSet checkCompulsorySessions(String studentID){
		return db.checkCompulsorySessions(String studentID);
	}
	
}