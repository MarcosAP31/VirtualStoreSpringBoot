package com.virtualstore.demo.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.virtualstore.demo.model.User;
@Repository
public interface IUser extends CrudRepository<User,Integer>{

}
