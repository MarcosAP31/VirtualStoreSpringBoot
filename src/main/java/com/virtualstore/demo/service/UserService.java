package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IUserService;
import com.virtualstore.demo.interfaces.IUser;
import com.virtualstore.demo.model.User;
@Service
public class UserService implements IUserService{
	@Autowired
	private IUser data;
	@Override
	public List<User> list() {
		return (List<User>)data.findAll();
	}
	@Override
	public Optional<User> listUserId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(User u) {
		
		int res=0;
		User user=data.save(u);
		if(!user.equals(null)) {
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
