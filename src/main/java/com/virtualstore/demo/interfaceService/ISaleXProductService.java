package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.SaleXProduct;
public interface ISaleXProductService {
	public List<SaleXProduct>list();
	public Optional<SaleXProduct>listSaleXProductId(int id);
	public int save(SaleXProduct s);
	public void delete(int id);
}
