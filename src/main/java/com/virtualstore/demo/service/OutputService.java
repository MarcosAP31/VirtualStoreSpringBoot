package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IOutputService;
import com.virtualstore.demo.interfaces.IOutput;
import com.virtualstore.demo.model.Output;
@Service
public class OutputService implements IOutputService{
	@Autowired
	private IOutput data;
	@Override
	public List<Output> list() {
		return (List<Output>)data.findAll();
	}
	@Override
	public Optional<Output> listOutputId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Output o) {
		
		int res=0;
		Output output=data.save(o);
		if(!output.equals(null)) {
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
