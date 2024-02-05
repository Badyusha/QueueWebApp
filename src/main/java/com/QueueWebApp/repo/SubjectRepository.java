package com.QueueWebApp.repo;

import com.QueueWebApp.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
	@Query("SELECT u FROM Subject u WHERE u.id = ?1")
	List<Subject> GetUserSubjects(Long subjectId);
}