package com.QueueWebApp.repo;

import com.QueueWebApp.models.Queue;
import com.QueueWebApp.models.Subject;
import com.QueueWebApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    @Query("SELECT u.subject.id FROM Queue u WHERE u.user.id = ?1")
    List<Long> GetUserSubjectsId(Long userId);

    @Query("SELECT u.user FROM Queue u WHERE u.subject.id = ?1")
    List<User> GetUsersBySubjectId(Long subjectId);

    @Query("SELECT u.subject FROM Queue u WHERE u.subject.id = ?1")
    Subject GetSubjectById(Long subjectId);
}