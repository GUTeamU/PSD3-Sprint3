package dbDriver;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dbDriver implements DatabaseInterface {
	
	public dbDriver(){
		this.createTables();
	}
	
    /**
     * Create the required database tables if they don't already exists.
     */
    public void createTables() {
        Connection connection = null;
        try {
        	
            connection = DriverManager.getConnection("jdbc:derby:data/BookingSystem;create=true");
            Statement statement = connection.createStatement();

            boolean autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);

            if (!tableExists("course")) {
                statement.addBatch("CREATE TABLE course(course_id VARCHAR(128) PRIMARY KEY, course_name VARCHAR(128))");
            }else{
            	System.out.println("Course already created");
            }

            if (!tableExists("student")) {
                statement.addBatch("CREATE TABLE student(student_id VARCHAR(128) PRIMARY KEY, student_name VARCHAR(128))");
            }else{
            	System.out.println("Student already created");
            }

            if (!tableExists("session")) {
                statement.addBatch("CREATE TABLE session(session_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), course_id VARCHAR(128), recurring BOOLEAN, compulsory BOOLEAN)");
            }else{
            	System.out.println("Session already created");
            }

            if (!tableExists("tutor")) {
                statement.addBatch("CREATE TABLE tutor(tutor_id VARCHAR(128) PRIMARY KEY, tutor_name VARCHAR(128))");
            }else{
            	System.out.println("Tutor already created");
            }

            if (!tableExists("timeslot")) {
                statement.addBatch("CREATE TABLE timeslot(timeslot_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), capacity INTEGER, time VARCHAR(128), duration INTEGER, day INTEGER, room VARCHAR(128), session_id INTEGER, tutor_id VARCHAR(128))");
            }else{
            	System.out.println("Timeslot already created");
            }

            if (!tableExists("student_course")) {
                statement.addBatch("CREATE TABLE student_course(student_id VARCHAR(128), course_id VARCHAR(128))");
            }else{
            	System.out.println("Studentcourse already created");
            }

            if (!tableExists("student_session")) {
                statement.addBatch("CREATE TABLE student_session(student_id VARCHAR(128), session_id INTEGER)");
            }else{
            	System.out.println("Studentsession already created");
            }

            if (!tableExists("session_timeslot")) {
                statement.addBatch("CREATE TABLE session_timeslot(session_id INTEGER, timeslot_id INTEGER)");
            }else{
            	System.out.println("session_timeslot already created");
            }

            if (!tableExists("student_timeslot")) {
                statement.addBatch("CREATE TABLE student_timeslot(student_id VARCHAR(128), timeslot_id INTEGER)");
            }else{
            	System.out.println("Studenttimeslot already created");
            }

            statement.executeBatch();
            connection.commit();
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            try {
                // probably want to inspect e.getErrorCode() to decide if rollback should be attempted.
                connection.rollback();
            } catch (SQLException r) {
                // TODO log
            }
            System.err.printf("SQL Error while creating tables: %s\n", e);
        }
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#addSession(int, java.lang.String,
	 * boolean, boolean)
	 */
	@Override
	public void addSession(String courseID, boolean recurring,
			boolean compulsory) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			int recurringInt = (recurring) ? 1 : 0;
			int compulsoryInt = (compulsory) ? 1 : 0;
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			System.out.println(statement 
					.executeUpdate("INSERT INTO session (course_id, recurring, compulsory) VALUES ("
							+ courseID
							+ ","
							+ recurringInt
							+ ","
							+ compulsoryInt + ");"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#sessTimeslot(int,int)
	 */
	public void sessTimeslot(int session_id,int timeslot_id){
		try{
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement
					.addBatch("INSERT INTO session_timeslot(session_id,timeslot_id) VALUES("
							+ session_id
							+ ","
							+ timeslot_id + ")");
			statement.executeBatch();

		}catch(SQLException e){
			e.printStackTrace();
		}

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#addTimeslot(int, java.lang.String,
	 * java.lang.String, int, java.lang.String)
	 */
	@Override
	public void addTimeslot(int capacity, String startTime, int duration,
			int day, String room) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
//			statement.addBatch("BEGIN;");
			statement
					.addBatch("INSERT INTO timeslot (time, duration, day, room, capacity) VALUES ("
							+ startTime
							+ ","
							+ duration
							+ ","
							+ day
							+ ","
							+ room + "," + capacity + ");");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#addCourse(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addCourse(String courseID, String name) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			statement
					.addBatch("INSERT INTO course(course_id, course_name) VALUES ("
							+ courseID + ", " + name + ");");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generate catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#addStudent(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addStudent(String studentID, String name) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			statement
					.addBatch("INSERT INTO student(student_id, student_name) VALUES ("
							+ studentID + ", " + name + ");");
			//statement.addBatch("COMMIT;");
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#addStudentToCourse(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addStudentToCourse(String studentID, String courseID) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			statement
					.addBatch("INSERT INTO student_course(student_id, course_id) VALUES ("
							+ studentID + ", " + courseID + ");");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#signUpToTimeslot(int, java.lang.String)
	 */
	@Override
	public void signUpToTimeslot(int timeID, String studentID) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT session_id FROM timeslot WHERE timeslot_id = "
							+ timeID + ";");
			int session_id = rs.getInt("session_id");

			//statement.addBatch("BEGIN;");
			statement
					.addBatch("INSERT INTO student_timeslot(timeslot_id, student_id) VALUES ("
							+ timeID + "," + studentID + ");");
			statement
					.addBatch("INSERT INTO student_session(student_id, session_id) VALUES ("
							+ studentID + ", " + session_id + ")");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#makeSessionRecurring(int)
	 */
	@Override
	public void makeSessionRecurring(int sessionID) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			statement
					.addBatch("UPDATE session SET recurring = 1 WHERE session_id = "
							+ sessionID + ";");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#bookSession(int, int)
	 */
	@Override
	public void bookSession(int sessionID, int timeID) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			//statement.addBatch("BEGIN;");
			statement.addBatch("UPDATE timeslot SET session_id = " + sessionID
					+ " WHERE time_id = " + timeID + ";");
			//statement.addBatch("COMMIT;");
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
	}

	//Non functional
	public int courseNumber(int num){
		try{
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			for (int index=0;index<=num;index++){
				statement.addBatch("INSERT INTO course(course_id) VALUES ("
							+ num + ")" );
				statement.executeBatch();
			}
			int counter=0;
			String newQuery = "SELECT * FROM course";
			ResultSet queryRes = statement.executeQuery(newQuery);
			while(queryRes.next()){
				counter+=1;
			}
			return counter;
			
		}catch (SQLException e){
			//TODO Auto-generated method stub
			
			return 0;
		}
		
		
	}

	public int userNumber(int num){
		if(num>0){

			try{

				Connection connection = DriverManager
						.getConnection("jdbc:derby:data/BookingSystem;create=true");
				Statement statement = connection.createStatement();
				for (int i=0;i < num; i++){
					statement.addBatch("INSERT INTO Student(student_id,student_name) VALUES("
						+ i + "," + i + ");" );
					statement.executeBatch();
				}
				String newQuery = "SELECT * FROM student";
				ResultSet queryRes = statement.executeQuery(newQuery);
				int counter =0;

				while(queryRes.next()){
					counter++;
				}
				connection.close();
				return counter;

			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int numberOfSlots(int sessionID,int num){
		if(num>0 && sessionID>0){
			try{
				Connection connection = DriverManager
						.getConnection("jdbc:derby:data/BookingSystem;create=true");
				Statement statement = connection.createStatement();
				for(int i=0;i<num;i++){
					statement.addBatch("INSERT INTO session_timeslot(session_id,timeslot_id) VALUES("
						+ sessionID + "," + i + ");");
					statement.executeBatch();
				}
				String newQuery = "SELECT count(timeslot_id) FROM session_timeslot WHERE session_id ="+ sessionID + " GROUP BY session_id";;
				ResultSet queryRes = statement.executeQuery(newQuery);
				int counter = 0;
				if(queryRes.next()){
					counter = queryRes.getInt(1);
				}
				connection.close();
				return counter;
			}catch (SQLException e){
				//todo
			}
		}
		return 0;

	}

	public boolean isOverlap(String startTime1, int duration1, String startTime2, int duration2){

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		int endhour1 = duration1 / 60 + Integer.valueOf(startTime1.substring(0,1));
		int endminute1 = duration1 % 60 + Integer.valueOf(startTime1.substring(3,4));

		int endhour2 = duration2 / 60 + Integer.valueOf(startTime2.substring(0,1));
		int endminute2 = duration2 % 60 + Integer.valueOf(startTime2.substring(3,4));
		String endTime1 = endhour1+":"+endminute1;
		String endTime2 = endhour2+":"+endminute2;

		if(startTime2.compareTo(endTime1)== -1){
			return true;
		}
		else{
			return false;
		}
	}


	// public boolean isClash(int studentID){
	// 	if(studentID >0){
	// 		try{
	// 			Connection connection = DriverManager
	// 					.getConnection("jdbc:derby:data/BookingSystem;create=true");
	// 			Statement statement = connection.createStatement();
	// 			String newQuery = "SELECT startTime,duration FROM timeslot WHERE student_id= "
	// 								+ studentID;
	// 			ResultSet queryRes = statement.executeQuery(newQuery);

	// 		}
	// 		catch(SQLException e){
	// 			//TODO

	// 		}
	// 	}
	// 	return 
	// }
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#checkCompulsorySessions(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ResultSet checkCompulsorySessions(String studentID) {
		ResultSet rs = null;
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement
					.executeQuery("SELECT student_course.course_id, session.session_id FROM (SELECT s.session_id, s.course_id FROM session AS s WHERE s.compulsory = 1) AS session INNER JOIN (SELECT c.course_id FROM course AS c) AS course ON session.course_id = course.course_id INNER JOIN student_course ON student_course.course_id = course.course_id INNER JOIN (SELECT st.student_id FROM student AS st WHERE st.student_id = "
							+ studentID
							+ ") AS student ON student.student_id = student_course.student_id WHERE session.session_id NOT IN (SELECT s_s.session_id FROM student_session AS s_s WHERE s_s.student_id = student.student_id)");
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DatabaseInterface#getCourseSessionDetails(int)
	 */
	@Override
	public ResultSet getCourseSessionDetails(String courseID) {
		ResultSet rs = null;
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement
					.executeQuery("SELECT timeslot.time, timeslot.room, tutor.tutor_name, student.student_id, student.student_name FROM (SELECT s.session_id FROM session AS s WHERE course_id = "
							+ courseID
							+ ") AS session INNER JOIN (SELECT t.time, t.room, t.tutor_id, t.timeslot_id, t.session_id FROM timeslot AS t) AS timeslot ON session.session_id = timeslot.session_id INNER JOIN (SELECT st.student_id, st.timeslot_id FROM student_timeslot AS st) AS student_timeslot ON timeslot.timeslot_id = student_timeslot.timeslot_id INNER JOIN (SELECT s.student_name, s.student_id FROM student AS s) AS student ON student.student_id = student_timeslot.student_id INNER JOIN (SELECT tt.tutor_id, tt.tutor_name FROM tutor AS tt ) AS tutor ON tutor.tutor_id = timeslot.tutor_id");
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return rs;
	}

	public Boolean tableExists(String tableName) 
			throws SQLException{

		Connection connection = DriverManager
				.getConnection("jdbc:derby:data/BookingSystem;create=true");

		DatabaseMetaData metaData = 
			connection.getMetaData();

		ResultSet resultSet = 
			metaData.getTables(
				null,
				null,
				tableName.toUpperCase(),
				new String[]{"TABLE"});

		Boolean result = resultSet.next();

		resultSet.close();
		connection.close();

		return result;
	}

	public ResultSet selectCourseSessions(String course) throws Exception {
		ResultSet rs = null;
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement
					.executeQuery("SELECT s.session_id FROM session AS s WHERE course_id = " 
							+ course);
			throw new Exception("statement: " );
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectSession(int session) {
		ResultSet rs = null;
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement
					.executeQuery("SELECT session_id, recurring FROM session WHERE session_id = "
							+ session);
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet checkTimeSlot(int capacity, String startTime,
			int duration, int day, String room) {
		ResultSet rs = null;
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:derby:data/BookingSystem;create=true");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement
					.executeQuery("SELECT timeslot_id " +
							"FROM timeslot " +
							"WHERE capacity=" + capacity  +
							"AND time=" + startTime +
							"AND duration=" + duration +
							"AND day=" + day +
							"AND room=" + room);
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return rs;
	}

}
