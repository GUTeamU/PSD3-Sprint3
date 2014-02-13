package AuthenticationRedux;

import org.osgi.framework.*;

public class Activator implements BundleActivator {
	
	ServiceRegistration<LoginInterface> LoginService;
	LoginInterface LoginInterface;
	LoginDriver login;
	
	public void start(BundleContext context){
		login = new LoginDriver();
		LoginService = context.registerService(LoginInterface.class, LoginInterface ,null );
	}
	
	public void stop(BundleContext context) throws Exception {
		LoginService.unregister();
		
