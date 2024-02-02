package com.QueueWebApp.repo;

import com.QueueWebApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> { }
