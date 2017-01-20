package common.model.connections;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Entitlement {

    private static Entitlement instance;
    private static SessionFactory sessionFactory;

   public Entitlement() throws Exception {
       Configuration configuration = new Configuration();
       configuration.configure("hibernate.cfg.xml");
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
               .applySettings(configuration.getProperties()).build();

       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
   }

    public static SessionFactory getSessionFactory() throws Exception {
        return getInstance().sessionFactory;
    }

    private static Entitlement getInstance() throws Exception {
        if(instance == null) {
            instance = new Entitlement();
        }
        return instance;
    }

}
