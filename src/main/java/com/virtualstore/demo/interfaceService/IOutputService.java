package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Output;
public interface IOutputService {
	public List<Output>list();
	public Optional<Output>listOutputId(int id);
	public int save(Output o);
	public void delete(int id);
}
