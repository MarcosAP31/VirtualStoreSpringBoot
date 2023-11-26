package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IProductService;
import com.virtualstore.demo.interfaces.IProduct;
import com.virtualstore.demo.model.Product;
@Service
public class ProductService implements IProductService{
	@Autowired
	private IProduct data;
	
	@Override
	public List<Product> list() {
		return (List<Product>)data.findAll();
	}

	@Override
	public Optional<Product> listProductId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Product c) {
		
		int res=0;
		Product client=data.save(c);
		if(!client.equals(null)) {
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
