package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IConversationService;
import com.virtualstore.demo.interfaces.IConversation;
import com.virtualstore.demo.model.Conversation;
@Service
public class ConversationService implements IConversationService{
	@Autowired
	private IConversation data;
	@Override
	public List<Conversation> list() {
		return (List<Conversation>)data.findAll();
	}
	@Override
	public Optional<Conversation> listConversationId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Conversation c) {
		
		int res=0;
		Conversation conversation=data.save(c);
		if(!conversation.equals(null)) {
			res=1;
		}
		// TODO Auto-generated method stub
		return res;
	}
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
