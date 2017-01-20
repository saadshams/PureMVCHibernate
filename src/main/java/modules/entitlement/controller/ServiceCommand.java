package modules.entitlement.controller;

import common.model.ServiceRequest;
import modules.entitlement.ApplicationFacade;
import modules.entitlement.ServiceModule;
import modules.entitlement.model.ServiceProxy;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;

public class ServiceCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification) {
        ServiceProxy serviceProxy = (ServiceProxy) getFacade().retrieveProxy(ServiceProxy.NAME);
        ServiceRequest serviceRequest = (ServiceRequest) notification.getBody();

        try {

            switch(serviceRequest.getRequestType()) {
                case ServiceModule.SELECT:
                    serviceRequest.setResultData(serviceProxy.select());
                    break;
                case ServiceModule.INSERT:
                    serviceRequest.setResultData(serviceProxy.insert());
                    break;

                case ServiceModule.UPDATE:
                    serviceRequest.setResultData(serviceProxy.update());
                    break;

                case ServiceModule.DELETE:
                    serviceRequest.setResultData(serviceProxy.delete());
                    break;
                case ServiceModule.SELECT_MULTIPLE:
                    serviceRequest.setResultData(serviceProxy.selectMultiple());
                    break;
                default:
                    serviceRequest.setResultData(serviceProxy.select());
            }

            sendNotification(ApplicationFacade.SERVICE_RESULT, serviceRequest);

        } catch (Exception exception) {
            serviceRequest.setException(exception);
            sendNotification(ApplicationFacade.SERVICE_FAULT, serviceRequest);
            exception.printStackTrace();
        }
    }

}
