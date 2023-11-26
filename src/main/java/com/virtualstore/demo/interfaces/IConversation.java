package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Conversation;
@Repository
public interface IConversation extends CrudRepository<Conversation,Integer>{

}

