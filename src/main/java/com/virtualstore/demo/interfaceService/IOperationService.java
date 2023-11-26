package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Operation;
public interface IOperationService {
	public List<Operation>list();
	public Optional<Operation>listOperationId(int id);
	public int save(Operation o);
	public void delete(int id);
}
