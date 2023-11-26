package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IBusinessService;
import com.virtualstore.demo.interfaces.IBusiness;
import com.virtualstore.demo.model.Business;
@Service
public class BusinessService implements IBusinessService{
	@Autowired
	private IBusiness data;
	@Override
	public List<Business> list() {
		return (List<Business>)data.findAll();
	}
	@Override
	public Optional<Business> listBusinessId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Business b) {
		
		int res=0;
		Business business=data.save(b);
		if(!business.equals(null)) {
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
