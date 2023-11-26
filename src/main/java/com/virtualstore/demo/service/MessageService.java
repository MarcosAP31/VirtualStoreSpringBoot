package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IMessageService;
import com.virtualstore.demo.interfaces.IMessage;
import com.virtualstore.demo.model.Message;
@Service
public class MessageService implements IMessageService{
	@Autowired
	private IMessage data;
	@Override
	public List<Message> list() {
		return (List<Message>)data.findAll();
	}
	@Override
	public Optional<Message> listMessageId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Message m) {
		
		int res=0;
		Message message=data.save(m);
		if(!message.equals(null)) {
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
