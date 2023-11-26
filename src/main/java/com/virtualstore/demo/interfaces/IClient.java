package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Client;
@Repository
public interface IClient extends CrudRepository<Client,Integer>{

}
