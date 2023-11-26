package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Session;
@Repository
public interface ISession extends CrudRepository<Session,Integer>{

}
