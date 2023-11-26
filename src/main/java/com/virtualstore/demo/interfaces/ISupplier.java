package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Supplier;
@Repository
public interface ISupplier extends CrudRepository<Supplier,Integer>{

}

