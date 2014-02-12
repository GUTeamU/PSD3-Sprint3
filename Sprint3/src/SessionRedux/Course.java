package SessionRedux;

import java.util.ArrayList;
import SessionRedux.sessions

public class Course{

	private String coursename; //PSD3
	private String id;		   // 3001
	private ArrayList<Sessions> session; // a List of sessions that the course has.
	private int maxCapacity;

	public Course(String coursename,String id, ArrayList<Sessions> session, int maxCapacity){

		this.coursename		= coursename;
		this.id				= id;
		this.session 		= session;
		this.maxCapacity 	= maxCapacity;
	}

	public String getCourseName(){return coursename;}

	public String getId(){return id;}

	public ArrayList<Sessions> getSession(){return session};

	public int maxCapacity(){return maxCapacity;}

	public void setCourseName(String coursename){this.coursename=coursename;}

	public void setId(String id){this.id = id;}

	public void setSession(ArrayList<Sessions> session){this.session=session;}

	public void setMaxCapacity(int maxCapacity){this.maxCapacity=maxCapacity;}
	




}