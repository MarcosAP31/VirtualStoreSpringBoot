package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Supplier;
public interface ISupplierService {
	public List<Supplier>list();
	public Optional<Supplier>listSupplierId(int id);
	public int save(Supplier c);
	public void delete(int id);
}
