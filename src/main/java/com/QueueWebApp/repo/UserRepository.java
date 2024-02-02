package com.QueueWebApp.repo;

import com.QueueWebApp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }


