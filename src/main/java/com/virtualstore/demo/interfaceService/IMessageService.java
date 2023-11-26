package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Message;
public interface IMessageService {
	public List<Message>list();
	public Optional<Message>listMessageId(int id);
	public int save(Message m);
	public void delete(int id);
}
