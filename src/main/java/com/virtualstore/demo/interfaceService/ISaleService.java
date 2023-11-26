package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Sale;
public interface ISaleService {
	public List<Sale>list();
	public Optional<Sale>listSaleId(int id);
	public int save(Sale s);
	public void delete(int id);
}
