package common.model;

public class ServiceRequest {

    Object requestData;
    String requestType;
    Object resultData;
    Exception exception;

    String sender;

    public ServiceRequest(Object requestData, String requestType, String sender) {
        this.requestData = requestData;
        this.requestType = requestType;
        this.sender = sender;
    }

    public Object getRequestData() {
        return requestData;
    }

    public void setRequestData(Object requestData) {
        this.requestData = requestData;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
