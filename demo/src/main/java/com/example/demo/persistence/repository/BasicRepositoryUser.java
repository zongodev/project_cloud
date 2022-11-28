package com.example.demo.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.entity.User; 

@Repository
public interface BasicRepositoryUser extends CrudRepository<User,Long>{
    
}
