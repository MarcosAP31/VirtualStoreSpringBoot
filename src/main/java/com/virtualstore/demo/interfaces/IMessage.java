package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Message;
@Repository
public interface IMessage extends CrudRepository<Message,Integer>{

}
