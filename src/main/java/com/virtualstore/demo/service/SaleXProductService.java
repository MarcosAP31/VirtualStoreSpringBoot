package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.ISaleXProductService;
import com.virtualstore.demo.interfaces.ISaleXProduct;
import com.virtualstore.demo.model.SaleXProduct;
@Service
public class SaleXProductService implements ISaleXProductService{
	@Autowired
	private ISaleXProduct data;
	@Override
	public List<SaleXProduct> list() {
		return (List<SaleXProduct>)data.findAll();
	}
	@Override
	public Optional<SaleXProduct> listSaleXProductId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(SaleXProduct s) {
		
		int res=0;
		SaleXProduct salexproduct=data.save(s);
		if(!salexproduct.equals(null)) {
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
