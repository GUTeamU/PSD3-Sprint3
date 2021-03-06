package dbDriver;

import org.osgi.framework.*;
public class Activator implements BundleActivator {
	
	ServiceRegistration<DatabaseInterface> dbService;
	DatabaseInterface dbInterface;
	dbDriver db;
	
	public void start(BundleContext context){
		db = new dbDriver();
		db.createTables();
		dbInterface = db;
		dbService = context.registerService(DatabaseInterface.class, dbInterface ,null );
	}
	
	public void stop(BundleContext context) throws Exception {
		dbService.unregister();
	}

}
