package SessionRedux;


import java.util.Date;


public class Sessions {

	// Might not need all of these.
	// Just kinda chucked them all in.


	// Need to get the time
	// Can't remember the import.
	private String courseName;	 // PSD3
	private String lecturerName; // Tim Storer
	private int capacity;		 // 100
	private boolean needTutor;	
	private String tutorName;	 // Some guy
	private Date dateOf;		 // 12/02/2014
	//private Time startTime;
	private boolean compulsory   //
	private int roomNum;         // 513
	private ArrayList<Students> register;
	private String recurringSession; // once, weekly, fortnight
	

	public String getCourseName(){return courseName;}

	public String getLecturerName(){return lecturerName;}

	public int getCapacity(){return capacity;}

	public String getTutorName(){return tutorName;}

	public Date getDate(){return date;}

	public Time getStartTime(){return startTime;}

	public int getroomNum(){return roomNum;}

	public String getRecurringSession(){return recurringSession;}

	public boolean isNeedTutor(){return needTutor;}

	public boolean isCompulsory(){return compulsory;}

	public void setCompulsory(boolean compulsory){this.compulsory=compulsory;}

	public void setNeedTutor(boolean needTutor){this.needTutor=needTutor;}

	public void setCourseName(String courseName){this.courseName=courseName;}

	public void setLecturerName(String lecturerName){this.lecturerName=lecturerName;}

	public void setCapacity(int capacity){this.capacity=capacity;}

	public void setDate(Date date){this.date=date;}

	//public void setStartTime(Time startTime){this.startTime=startTime;}

	public void setRecurringSession(String recurringSession){this.recurringSession=recurringSession;}
}
	