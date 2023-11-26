package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.ISessionService;
import com.virtualstore.demo.interfaces.ISession;
import com.virtualstore.demo.model.Session;
@Service
public class SessionService implements ISessionService{
	@Autowired
	private ISession data;
	@Override
	public List<Session> list() {
		return (List<Session>)data.findAll();
	}
	@Override
	public Optional<Session> listSessionId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Session s) {
		
		int res=0;
		Session session=data.save(s);
		if(!session.equals(null)) {
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
