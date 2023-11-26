package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IOperationService;
import com.virtualstore.demo.interfaces.IOperation;
import com.virtualstore.demo.model.Operation;
@Service
public class OperationService implements IOperationService{
	@Autowired
	private IOperation data;
	@Override
	public List<Operation> list() {
		return (List<Operation>)data.findAll();
	}
	@Override
	public Optional<Operation> listOperationId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Operation o) {
		
		int res=0;
		Operation operation=data.save(o);
		if(!operation.equals(null)) {
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
