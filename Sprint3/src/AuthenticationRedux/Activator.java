package AuthenticationRedux;

import org.osgi.framework.*;

public class Activator implements BundleActivator {
	
	ServiceRegistration<LoginInterface> LoginService;
	
	public void start(BundleContext context){
		LoginService = context.registerService(LoginInterface.class, new LoginDriver(), null);
	}
	
	public void stop(BundleContext context) throws Exception {
		LoginService.unregister();
	}
}
