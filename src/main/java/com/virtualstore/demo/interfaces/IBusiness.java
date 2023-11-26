package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Business;
@Repository
public interface IBusiness extends CrudRepository<Business,Integer>{

}
