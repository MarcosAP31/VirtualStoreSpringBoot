package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IEntryService;
import com.virtualstore.demo.interfaces.IEntry;
import com.virtualstore.demo.model.Entry;
@Service
public class EntryService implements IEntryService{
	@Autowired
	private IEntry data;
	@Override
	public List<Entry> list() {
		return (List<Entry>)data.findAll();
	}
	@Override
	public Optional<Entry> listEntryId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Entry e) {
		
		int res=0;
		Entry entry=data.save(e);
		if(!entry.equals(null)) {
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
