package com.pointwest.capstone.repositories;

import com.pointwest.capstone.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
}
