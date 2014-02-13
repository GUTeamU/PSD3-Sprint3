package dbDriver;
import java.sql.*;

public interface DatabaseInterface{
	/**
	 * Create a new session for a course
	 * @param courseID, the unique course id of the course the session represents
	 * @param recurring, a boolean as to whether or not the session is recurs 
	 * @param compulsory, a boolean as to whether or not the session is compulsory
	 */
	public void addSession(String courseID, boolean recurring, boolean compulsory);

	/**
	 * Adds a time slot to the timetable but does not associate it with a session
	 * @param capacity, the capacity of the session
	 * @param startTime, the starting time for the time slot
	 * @param duration, the duration of the time slot
	 * @param day, what day of the week the time slot occurs
	 * @param room, the room where the time is available
	 */
	public void addTimeslot(int capacity, String startTime, int duration, int day, String room);
	
	/**
	 * Creates a new course
	 * @param courseID, the unique course id of the course you want to create
	 * @param name, the colloquial name of the course
	 */
	public void addCourse(String courseID, String name);

	/**
	 * Adds a new student
	 * @param studentID, students unique integer
	 * @param name, students full name
	 */
	public void addStudent(String studentID, String name);

	/**
	 * Add a student to the student_course relation, effectively enrolling them in a course
	 * @param studentID, the students unique ID
	 * @param courseID, the unique course id of the course the student is joining
	 */
	public void addStudentToCourse(String studentID, String courseID);

	/**
	 * Allows a student to sign up to a time slot
	 * @param timeID, the time slots unique ID
	 * @param studentID, the students unique ID
	 */
	public void signUpToTimeslot(int timeID, String studentID);

	/**
	 * Sets the recurring flag for a session to be true
	 * @param sessionID, the session to be made recurring
	 */
	public void makeSessionRecurring(int sessionID);

	/**
	 * Assigns a time slot to a session
	 * @param sessionID, the session the time slot will belong to
	 * @param timeID, the time slot you wish to assign to the session
	 */
	public void bookSession(int sessionID, int timeID);

	/**
	 * Checks whether the student is enrolled in all their compulsory courses
	 * @param studentID, the students unique ID
	 * @returns the compulsory courses the student is not enrolled in
	 */
	public ResultSet checkCompulsorySessions(String studentID);

	/**
	 * Gets details the of the session a course runs
	 * @param courseID, the unique course id of the course you want to know about
	 * @returns The times it has a session running,
	 * the rooms the session runs in,
	 * the name of the tutors that take the sessions,
	 * the student ID's of the students assigned to the session and 
	 * the student's names.
	 */
	public ResultSet getCourseSessionDetails(int courseID);
}
