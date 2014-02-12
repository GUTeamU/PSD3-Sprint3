
import java.util.Date;

public class Sessions {
	private String courseName;
	private String lecturerName;
	private int capacity;
	private boolean needTutor;
	private Date startTime;
	private Date endTime;
	private Date startDate;
	private Date endDate;

	public Sessions(String cName,String lName,int cap,boolean needT,Date sTime,Date eTime, Date sDate,Date eDate){
		courseName=cName;
		lecturerName=lName;
		capacity=cap;
		needTutor=needT;
		startTime=sTime;
		endTime=eTime;
		startDate=sDate;
		endDate=eDate;
	}

	public String getCourseName() {return courseName;}

	public String getLecturerName() {return lecturerName;}

	public int getCapacity() {return capacity;}

	public boolean isNeedTutor() {return needTutor;}

	public Date getStartTime() {return startTime;}

	public Date getEndTime() {return endTime;}

	public Date getStartDate() {return startDate;}

	public Date getEndDate() {return endDate;}
	
	
		
}
