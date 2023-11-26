package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.User;
public interface IUserService {
	public List<User>list();
	public Optional<User>listUserId(int id);
	public int save(User u);
	public void delete(int id);
}
