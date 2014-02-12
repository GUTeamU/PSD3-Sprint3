
Package UserRedux;


import UserRedux.Admin;
import UserRedux.Tutor;
import UserRedux.Lecturer;
import UserRedux.Student;
import SessionRedux.Sessions;
import SessionRedux.Course;


public class Users implements Student,Admin,Lecturer,Tutor {
	
	private boolean student;
	private boolean admin;
	private boolean lecturer;
	private boolean tutor;
	private String 	matriculation;

	public Users(boolean student,boolean admin,boolean lecturer,boolean tutor,String password,String matriculation){
		this.student  		= student;
		this.admin    		= admin;
		this.lecturer		= lecturer;
		this.tutor			= tutor;
		this.matriculation 	= matriculation;
	}

	public String getMatriculation(){return matriculation;}

	public String getPassword(){return password;}

	public boolean isStudent(){return student;}

	public boolean isAdmin(){return admin;}

	public boolean isTutor(){return tutor;}

	public boolean isLecturer(){return lecturer;}

	public void setStudent(boolean student){this.student=student;}

	public void setAdmin(boolean admin){this.admin=admin;}

	public void setTutor(boolean tutor){this.tutor=tutor;}

	public void setLecturer(boolean lecturer){this.lecturer=lecturer;}

	public void setMatriculation(String matriculation){this.matriculation=matriculation;}

	public void setPassword(String password){this.password=password;}


	/*
	 *
	 * Following methods are to fulfil the requirements of the userstories and other general methods.
	 * They will just be Stubs for now.
	 */

	public boolean importMC(Course newCourse){
		//STUB
	}

	public void addSession(Course course){
		//STUB
	}

	public void recurring(Session Session, String recurring){
		//STUB
	}

	public ArrayList<Sessions> viewSession(Course course){
		//STUB
	}

	public Sessions newSlot(){ // unsure of the parameters. add a new timetable slot for each session. Date/Time?
		//STUB
	}

	public boolean slotBooking(Session session){
		//STUB
	}
    
    public void assignRoom(Session session, int roomNumber){
    	//STUB
    }


	