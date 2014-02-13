package AuthenticationRedux;

public class LoginDriver implements LoginInterface {
	
	private String username;
	private String password;

	public String getUsername(){
		return username;
	}

	public String loggedin(String username,String password) {
		return username;
	}
	

	
}
