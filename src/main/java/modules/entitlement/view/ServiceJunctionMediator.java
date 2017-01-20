package modules.entitlement.view;

import common.model.ServiceRequest;
import modules.entitlement.ApplicationFacade;
import modules.entitlement.ServiceModule;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.utilities.pipes.interfaces.IPipeMessage;
import org.puremvc.java.multicore.utilities.pipes.messages.Message;
import org.puremvc.java.multicore.utilities.pipes.plumbing.Junction;
import org.puremvc.java.multicore.utilities.pipes.plumbing.JunctionMediator;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceJunctionMediator extends JunctionMediator {

    public static final String NAME = "ServiceJunctionMediator";

    public ServiceJunctionMediator() {
        super(NAME, new Junction());
    }

    @Override
    public String[] listNotificationInterests() {
        ArrayList<String> interests = new ArrayList<String>(Arrays.asList(super.listNotificationInterests()));
        interests.add(ApplicationFacade.SERVICE_RESULT);
        interests.add(ApplicationFacade.SERVICE_FAULT);
        return interests.toArray(new String[interests.size()]);
    }

    @Override
    public void handleNotification(INotification note) {
        ServiceRequest serviceRequest = (ServiceRequest) note.getBody();
        switch (note.getName()) {
            case ApplicationFacade.SERVICE_RESULT:
            case ApplicationFacade.SERVICE_FAULT:
                //this.getJunction().sendMessage(serviceRequest.getSender(), new Message(serviceRequest.getRequestType(), serviceRequest.getResultData(), ServiceModule.NAME, 0));
                break;

            default:
                super.handleNotification(note);
        }
    }

    @Override
    public void handlePipeMessage(IPipeMessage message) {
        getFacade().sendNotification(ApplicationFacade.SERVICE, new ServiceRequest(message.getBody(), message.getType(), (String) message.getHeader())); //requestData, requestType, sender
    }
}
