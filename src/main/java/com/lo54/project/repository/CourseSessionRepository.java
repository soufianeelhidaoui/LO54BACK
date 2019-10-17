package com.lo54.project.repository;

import com.lo54.project.model.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {

}
