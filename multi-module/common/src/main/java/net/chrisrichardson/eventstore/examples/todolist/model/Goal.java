package net.chrisrichardson.eventstore.examples.todolist.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Goal {
	
	
	public Goal () {}
	
	public Goal (GoalInfo goalInfo) {
	    setClientXRefId(goalInfo.getPrimaryClient().getClientXRefId());
	    setGoalName(goalInfo.getGoalName());
	    setGoalStatusCode(goalInfo.getGoalStatusCode());
	    setGoalSubtypeCode(goalInfo.getGoalSubtypeCode());
	    setGoalTypeCode(goalInfo.getGoalTypeCode());
	    setNote(goalInfo.getNote());
	    setCompleteDate(goalInfo.getSaveForAnythingDetails().getCompleteDate());
	    setCost(goalInfo.getSaveForAnythingDetails().getCost());
	    setCostFrequencyCode(goalInfo.getSaveForAnythingDetails().getCostFrequencyCode());
	    setCostTimeValue(goalInfo.getSaveForAnythingDetails().getCostTimeValue());
	    setCurrencyCode(goalInfo.getSaveForAnythingDetails().getCurrencyCode());
	    setInvestmentPropertyInd(goalInfo.getSaveForAnythingDetails().getInvestmentPropertyInd());
	    setOwnedHomeCanadaInd(goalInfo.getSaveForAnythingDetails().getOwnedHomeCanadaInd());
	    setRecurrence(goalInfo.getSaveForAnythingDetails().getRecurrence());
	    setStartDate(goalInfo.getSaveForAnythingDetails().getStartDate());
	    setTargetDateCode(goalInfo.getSaveForAnythingDetails().getTargetDateCode());
	    setCreateBy(goalInfo.getCreateBy());
	    setCreateOn(goalInfo.getCreateOn());
	    setModifiedBy(goalInfo.getModifiedBy());
	    setModifiedOn(goalInfo.getModifiedOn());
	}

    @Id
    @Column(name = "goal_id")
	private String goalId;
    
    @Column(name = "client_xref_id")
    private String clientXRefId;
    
    @Column(name = "goal_name")
    private String goalName;
    
    @Column(name = "goal_status_code")
	private String goalStatusCode;

    @Column(name = "goal_subtype_code")
    private String goalSubtypeCode;

    @Column(name = "goal_type_code")
    private String goalTypeCode;

    @Column(name = "note")
    private String note;
    
    @Column(name = "complete_date")
	private String completeDate;
	
    @Column(name = "cost")
	private String cost;

    @Column(name = "cost_frequency_code")
    private String costFrequencyCode;
    
    @Column(name = "cost_time_value")
	private String costTimeValue;
	
    @Column(name = "currency_code")
	private String currencyCode;
	
    @Column(name = "investment_ind")
	private String investmentPropertyInd;
	
    @Column(name = "owned_homecdn_ind")
	private String ownedHomeCanadaInd;

    @Column(name = "recurrence")
    private String recurrence;
    
    @Column(name = "start_date")
	private String startDate;
	
    @Column(name = "target_date_code")
	private String targetDateCode;

    @Column(name = "create_by")
    private String createBy;
    
    @Column(name = "create_on")
	private String createOn;
	
    @Column(name = "modified_by")
    private String modifiedBy;
    
    @Column(name = "modified_on")
	private String modifiedOn;

	public String getGoalId() {
		return goalId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public String getClientXRefId() {
		return clientXRefId;
	}

	public void setClientXRefId(String clientXRefId) {
		this.clientXRefId = clientXRefId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCostFrequencyCode() {
		return costFrequencyCode;
	}

	public void setCostFrequencyCode(String costFrequencyCode) {
		this.costFrequencyCode = costFrequencyCode;
	}

	public String getCostTimeValue() {
		return costTimeValue;
	}

	public void setCostTimeValue(String costTimeValue) {
		this.costTimeValue = costTimeValue;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getInvestmentPropertyInd() {
		return investmentPropertyInd;
	}

	public void setInvestmentPropertyInd(String investmentPropertyInd) {
		this.investmentPropertyInd = investmentPropertyInd;
	}

	public String getOwnedHomeCanadaInd() {
		return ownedHomeCanadaInd;
	}

	public void setOwnedHomeCanadaInd(String ownedHomeCanadaInd) {
		this.ownedHomeCanadaInd = ownedHomeCanadaInd;
	}

	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getTargetDateCode() {
		return targetDateCode;
	}

	public void setTargetDateCode(String targetDateCode) {
		this.targetDateCode = targetDateCode;
	}

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
 
    
}
