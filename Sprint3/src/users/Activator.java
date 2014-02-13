package users;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import dbDriver.DatabaseInterface;

public class Activator implements BundleActivator {
	
	private Users user;
	private DatabaseInterface db;
	
	public void start(BundleContext context){
		
		
		
		ServiceReference<DatabaseInterface> serviceReference = 
				context.getServiceReference(DatabaseInterface.class);
		
		db = context.getService(serviceReference);
		user = new Users(db);
	}
	
	public void stop(BundleContext context) throws Exception {
		
	}

}
