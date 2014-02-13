package AuthenticationRedux;

import org.osgi.framework.*;

public class Activator implements BundleActivator {
	
	ServiceRegistration<LoginInterface> loginService;
	LoginInterface loginInterface;
	LoginDriver login;
	
	public void start(BundleContext context){
		login = new LoginDriver();
		loginInterface = login;
		loginService = context.registerService(LoginInterface.class, loginInterface ,null );
	}
	
	public void stop(BundleContext context) throws Exception {
		loginService.unregister();
	}
}
