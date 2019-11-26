package com.lo54.project.repository;

import com.lo54.project.model.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {

    List<CourseSession> findByCourse_Title(String courseTitle);
    List<CourseSession> findByCourse_TitleAndStartDateBeforeAndEndDateAfter(String courseTitle, Date startDate, Date endDate);
    List<CourseSession> findByCourse_TitleAndLocation_City(String courseTitle, String city);
    List<CourseSession> findByCourse_TitleAndStartDateBeforeAndEndDateAfterAndLocation_City(String courseTitle, Date date1, Date date2, String city);
}
