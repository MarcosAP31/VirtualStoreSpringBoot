package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.ISaleService;
import com.virtualstore.demo.interfaces.ISale;
import com.virtualstore.demo.model.Sale;
@Service
public class SaleService implements ISaleService{
	@Autowired
	private ISale data;
	@Override
	public List<Sale> list() {
		return (List<Sale>)data.findAll();
	}
	@Override
	public Optional<Sale> listSaleId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Sale s) {
		
		int res=0;
		Sale sale=data.save(s);
		if(!sale.equals(null)) {
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
