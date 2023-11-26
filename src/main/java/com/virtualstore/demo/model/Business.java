package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "business")
public class Business {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int BusinessId;
	public String Description;
	public long Value;
	public String Reference;
	public String State;
	public String CreationDate;
	public String ClosingDate;
	public String Commentary;
	public String Activity;
	public String NextActivity;
	public Business() {
		// TODO Auto generated constructor stub
		this.Value = 0;
	}
	public Business(int BusinessId,String Description,long Value,String Reference,String State,String CreationDate,String ClosingDate,
			String Commentary,String Activity,String NextActivity) {
		super();
		this.BusinessId = BusinessId;
		this.Description = Description;
		this.Value = Value;
		this.Reference = Reference;
		this.State = State;
		this.CreationDate = CreationDate;
		this.ClosingDate = ClosingDate;
		this.Commentary = Commentary;
		this.Activity = Activity;
		this.NextActivity = NextActivity;

	}
	public int getBusinessId() {
		return BusinessId;
	}
	public void setBusinessId(int BusinessId) {
		this.BusinessId = BusinessId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public long getValue() {
		return Value;
	}
	public void setValue(long Value) {
		this.Value = Value;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String Reference) {
		this.Reference = Reference;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String CreationDate) {
		this.CreationDate = CreationDate;
	}
	public String getClosingDate() {
		return ClosingDate;
	}
	public void setClosingDate(String ClosingDate) {
		this.ClosingDate = ClosingDate;
	}
	public String getCommentary() {
		return Commentary;
	}
	public void setCommentary(String Commentary) {
		this.Commentary = Commentary;
	}
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String Activity) {
		this.Activity = Activity;
	}
	public String getNextActivity() {
		return NextActivity;
	}
	public void setNextActivity(String NextActivity) {
		this.NextActivity = NextActivity;
	}
}
