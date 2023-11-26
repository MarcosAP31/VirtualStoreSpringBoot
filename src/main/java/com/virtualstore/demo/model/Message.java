package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int MessageId;
	public String Content;
	public String ShippingDate;
	public int UserId;
	public String State;
	public int ConversationId;
	public Message() {
	}
	public Message(int MessageId,String Content,String ShippingDate,int UserId,String State,int ConversationId) {
		super();
		this.MessageId = MessageId;
		this.Content = Content;
		this.ShippingDate = ShippingDate;
		this.UserId = UserId;
		this.State = State;
		this.ConversationId = ConversationId;
	}
	public int getMessageId() {
		return MessageId;
	}
	public void setMessageId(int MessageId) {
		this.MessageId = MessageId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}
	public String getShippingDate() {
		return ShippingDate;
	}
	public void setShippingDate(String ShippingDate) {
		this.ShippingDate = ShippingDate;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	public int getConversationId() {
		return ConversationId;
	}
	public void setConversationId(int ConversationId) {
		this.ConversationId = ConversationId;
	}
}
