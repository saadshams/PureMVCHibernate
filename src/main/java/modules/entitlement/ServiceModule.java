package modules.entitlement;

import common.model.ServiceRequest;

public class ServiceModule {

    public static String NAME = "entitlement";

    public static final String SELECT = "select";
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    public static final String SELECT_MULTIPLE = "selectMultiple";

    private ApplicationFacade facade;

    public ServiceModule() {
        facade = ApplicationFacade.getInstance(NAME);
        facade.startup();
    }

    public void service() {
        facade.service(new ServiceRequest(null, SELECT_MULTIPLE, null));
    }

}
