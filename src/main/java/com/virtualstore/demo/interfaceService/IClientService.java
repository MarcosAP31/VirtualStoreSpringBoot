package com.virtualstore.demo.interfaceService;
import java.util.List;
import java.util.Optional;
import com.virtualstore.demo.model.Client;
public interface IClientService {
	public List<Client>list();
	public Optional<Client>listClientId(int id);
	public int save(Client c);
	public void delete(int id);
}
