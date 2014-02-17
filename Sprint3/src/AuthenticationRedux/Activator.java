package AuthenticationRedux;

import org.osgi.framework.*;

public class Activator implements BundleActivator {
	
	ServiceRegistration<LoginInterface> loginService;
	
	public void start(BundleContext context){
		loginService = context.registerService(LoginInterface.class, new LoginDriver(), null);
	}
	
	public void stop(BundleContext context) throws Exception {
		loginService.unregister();
	}
}
