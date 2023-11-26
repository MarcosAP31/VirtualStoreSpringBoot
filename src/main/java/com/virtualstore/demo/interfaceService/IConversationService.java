package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Conversation;
public interface IConversationService {
	public List<Conversation>list();
	public Optional<Conversation>listConversationId(int id);
	public int save(Conversation c);
	public void delete(int id);
}
