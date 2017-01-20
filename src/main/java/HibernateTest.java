import modules.entitlement.ApplicationFacade;
import modules.entitlement.ServiceModule;

public class HibernateTest {

    private static ServiceModule serviceModule;

    public static void main(String[] args) {
        serviceModule = new ServiceModule();
        serviceModule.service();
    }

}
