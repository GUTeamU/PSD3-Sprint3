package Authentication;

import org.osgi.framework.*;
public class Activator implements BundleActivator {
	
	ServiceRegistration<?> loginService;
	
	public void start(BundleContext context){
		Login login = new Login();
		loginService = context.registerService(Login.class.getName(),login ,null );
	}
	
	public void stop(BundleContext context) throws Exception {
		loginService.unregister();
	}

}
