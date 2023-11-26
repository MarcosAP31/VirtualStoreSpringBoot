package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Business;
public interface IBusinessService {
	public List<Business>list();
	public Optional<Business>listBusinessId(int id);
	public int save(Business b);
	public void delete(int id);
}
