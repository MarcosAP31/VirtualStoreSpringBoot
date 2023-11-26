package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Entry;
public interface IEntryService {
	public List<Entry>list();
	public Optional<Entry>listEntryId(int id);
	public int save(Entry e);
	public void delete(int id);
}
