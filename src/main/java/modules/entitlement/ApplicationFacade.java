package modules.entitlement;

import common.model.ServiceRequest;
import modules.entitlement.controller.StartupCommand;
import org.puremvc.java.multicore.patterns.facade.Facade;

public class ApplicationFacade extends Facade {

    public static final String STARTUP = "startup";

    public static final String SERVICE = "service";
    public static final String SERVICE_RESULT = "service/result";
    public static final String SERVICE_FAULT = "service/fault";

    public ApplicationFacade(String key) {
        super(key);
    }

    @Override
    protected void initializeController() {
        super.initializeController();
        registerCommand(STARTUP, new StartupCommand());
    }

    public static ApplicationFacade getInstance(String key) {
        if(instanceMap.get(key) == null) {
            instanceMap.put(key, new ApplicationFacade(key));
        }
        return (ApplicationFacade) instanceMap.get(key);
    }

    public void startup() {
        sendNotification(STARTUP);
    }

    public void service(ServiceRequest serviceRequest) {
        sendNotification(SERVICE, serviceRequest);
    }
}
