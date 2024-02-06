package com.QueueWebApp.repo;

import com.QueueWebApp.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    @Query("SELECT u.subject.id FROM Queue u WHERE u.user.id = ?1")
    List<Long> GetUserSubjectsId(Long userId);
}