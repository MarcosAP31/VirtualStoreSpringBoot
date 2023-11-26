package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Operation;
@Repository
public interface IOperation extends CrudRepository<Operation,Integer>{

}
