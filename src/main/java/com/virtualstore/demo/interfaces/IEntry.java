package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Entry;
@Repository
public interface IEntry extends CrudRepository<Entry,Integer>{

}
