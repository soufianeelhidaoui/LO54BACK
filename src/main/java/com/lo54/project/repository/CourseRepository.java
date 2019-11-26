package com.lo54.project.repository;

import com.lo54.project.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//   List<Course> findByTitleContaining(String keyword);
//    List<Course> findCoursesByLocation_IdLocation(Long location);
//    @Query(value = "SELECT CO.* FROM COURSE CO INNER JOIN COURSE_SESSION CS ON CO.ID_COURSE = CS.ID_COURSE WHERE DATE(:date) BETWEEN START_DATE AND END_DATE", nativeQuery = true)
//    List<Course> findByDate(Date date);
}
