package net.chrisrichardson.eventstore.examples.todolist.model;


public class GoalInfo extends DomainObject {
	
	public GoalInfo (String goalName) {
		setGoalName(goalName);
	}
	
	public GoalInfo () {}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalStatusCode() {
		return goalStatusCode;
	}
	public void setGoalStatusCode(String goalStatusCode) {
		this.goalStatusCode = goalStatusCode;
	}
	public String getGoalSubtypeCode() {
		return goalSubtypeCode;
	}
	public void setGoalSubtypeCode(String goalSubtypeCode) {
		this.goalSubtypeCode = goalSubtypeCode;
	}
	public String getGoalTypeCode() {
		return goalTypeCode;
	}
	public void setGoalTypeCode(String goalTypeCode) {
		this.goalTypeCode = goalTypeCode;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Client getPrimaryClient() {
		return primaryClient;
	}
	public void setPrimaryClient(Client primaryClient) {
		this.primaryClient = primaryClient;
	}
	public SaveForAnythingDetails getSaveForAnythingDetails() {
		return saveForAnythingDetails;
	}
	public void setSaveForAnythingDetails(SaveForAnythingDetails saveForAnythingDetails) {
		this.saveForAnythingDetails = saveForAnythingDetails;
	}
	private String createBy;
	private String createOn;
	private String goalId;
	private String goalName;
	private String goalStatusCode;
	private String goalSubtypeCode;
	private String goalTypeCode;
	private String modifiedBy;
	private String modifiedOn;
	private String note;
	private Client primaryClient;
	private SaveForAnythingDetails saveForAnythingDetails;
	
	
}
