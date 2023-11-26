package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Output;
@Repository
public interface IOutput extends CrudRepository<Output,Integer>{

}
