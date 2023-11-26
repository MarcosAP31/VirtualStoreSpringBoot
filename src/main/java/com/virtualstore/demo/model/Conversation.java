package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ConversationId;
	public String Name;
	public String CreationDate;
	public Conversation() {
	}
	public Conversation(int ConversationId,String Name,String CreationDate) {
		super();
		this.ConversationId = ConversationId;
		this.Name = Name;
		this.CreationDate = CreationDate;
	}
	public int getConversationId() {
		return ConversationId;
	}
	public void setConversationId(int ConversationId) {
		this.ConversationId = ConversationId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(String CreationDate) {
		this.CreationDate = CreationDate;
	}
}

