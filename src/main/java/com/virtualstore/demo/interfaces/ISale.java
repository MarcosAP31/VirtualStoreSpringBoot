package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Sale;
@Repository
public interface ISale extends CrudRepository<Sale,Integer>{

}
