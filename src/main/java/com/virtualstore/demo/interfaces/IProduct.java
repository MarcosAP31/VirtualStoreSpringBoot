package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.Product;
@Repository
public interface IProduct extends CrudRepository<Product,Integer>{

}
