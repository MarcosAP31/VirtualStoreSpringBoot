package com.virtualstore.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.demo.interfaceService.IClientService;
import com.virtualstore.demo.interfaces.IClient;
import com.virtualstore.demo.model.Client;
@Service
public class ClientService implements IClientService{
	@Autowired
	private IClient data;
	
	@Override
	public List<Client> list() {
		return (List<Client>)data.findAll();
	}

	@Override
	public Optional<Client> listClientId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Client c) {
		
		int res=0;
		Client client=data.save(c);
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
