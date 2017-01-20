package modules.entitlement.controller;

import modules.entitlement.ApplicationFacade;
import modules.entitlement.model.ServiceProxy;
import modules.entitlement.view.ServiceJunctionMediator;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;

public class StartupCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification) {
        getFacade().registerCommand(ApplicationFacade.SERVICE, new ServiceCommand());

        getFacade().registerProxy(new ServiceProxy());

        getFacade().registerMediator(new ServiceJunctionMediator());
    }
}
