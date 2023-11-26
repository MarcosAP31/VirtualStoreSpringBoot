package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Product;
public interface IProductService {
	public List<Product>list();
	public Optional<Product>listProductId(int id);
	public int save(Product c);
	public void delete(int id);
}
