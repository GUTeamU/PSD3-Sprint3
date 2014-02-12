package User;

public class Lecturer extends Users {
	
	private String firstname;
	private String lastname;
	
	public Lecturer(String matric, String perm,String fname,String lname) {
		super(matric, perm);
		firstname = fname;
		lastname = lname;
		
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	

}
