package users;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import AuthenticationRedux.LoginInterface;
import dbDriver.DatabaseInterface;

public class Activator implements BundleActivator {
	
	private Users user;
	private DatabaseInterface db;
	private LoginInterface login;
	public String username = "Admin";
	public String password = "pass";
	
	public void start(BundleContext context){
		
		ServiceReference<LoginInterface> loginReference = 
				context.getServiceReference(LoginInterface.class);
		
		login = context.getService(loginReference);
		String permissions = login.loggedin(username, password);
		
		ServiceReference<DatabaseInterface> dbReference = 
				context.getServiceReference(DatabaseInterface.class);
		
		db = context.getService(dbReference);
		
		if(permissions.equals("Admin"))
			user = new Admin(db);
		else if(permissions.equals("Lecturer"))
			user = new Lecturer(db);
		else if (permissions.equals("Student"))
			user = new Student(db);
		else{
			System.err.println("Invalid permission to accesss system.");
		}
	}
	
	public void stop(BundleContext context) throws Exception {
		
	}

}
