package com.testproject.testproject.Repository;

import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByNameContains(String name);
}
