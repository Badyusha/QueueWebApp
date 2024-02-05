package com.QueueWebApp.repo;

import com.QueueWebApp.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {
}