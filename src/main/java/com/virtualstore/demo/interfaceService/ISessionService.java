package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Session;
public interface ISessionService {
	public List<Session>list();
	public Optional<Session>listSessionId(int id);
	public int save(Session s);
	public void delete(int id);
}
