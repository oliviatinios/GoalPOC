package net.chrisrichardson.eventstore.examples.todolist.model;

public class Client extends DomainObject{

	private String clientId;
	private String clientTypeCode;
	private String clientXRefId;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientTypeCode() {
		return clientTypeCode;
	}
	public void setClientTypeCode(String clientTypeCode) {
		this.clientTypeCode = clientTypeCode;
	}
	public String getClientXRefId() {
		return clientXRefId;
	}
	public void setClientXRefId(String clientXRefId) {
		this.clientXRefId = clientXRefId;
	}
	
}
