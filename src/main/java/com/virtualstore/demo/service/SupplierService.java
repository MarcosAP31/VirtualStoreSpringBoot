package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.ISupplierService;
import com.virtualstore.demo.interfaces.ISupplier;
import com.virtualstore.demo.model.Supplier;
@Service
public class SupplierService implements ISupplierService{
	@Autowired
	private ISupplier data;
	
	@Override
	public List<Supplier> list() {
		return (List<Supplier>)data.findAll();
	}

	@Override
	public Optional<Supplier> listSupplierId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Supplier s) {
		
		int res=0;
		Supplier Supplier=data.save(s);
		if(!Supplier.equals(null)) {
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
