package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.SaleXProduct;
@Repository
public interface ISaleXProduct extends CrudRepository<SaleXProduct,Integer>{

}
