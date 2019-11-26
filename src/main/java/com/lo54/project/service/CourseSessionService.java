package com.lo54.project.service;

import com.lo54.project.model.Course;
import com.lo54.project.model.CourseSession;
import com.lo54.project.repository.CourseSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
/**
 * Session business layer
 */
public class CourseSessionService {


    private final CourseSessionRepository repository;

    /**
     * Add new sessions
     * @param courseSession
     * @return CourseSession
     */
    public CourseSession create(CourseSession courseSession){
        return repository.save(courseSession);
    }

    /**
     * Update an existing session
     * @param courseSession
     * @return CourseSession
     */
    public CourseSession update(CourseSession courseSession){
        CourseSession record = repository.findById(courseSession.getIdCourseSession()).get();
        record.setStartDate(courseSession.getStartDate());
        record.setEndDate(courseSession.getEndDate());
        record.setMax(courseSession.getMax());
        record.setCourse(courseSession.getCourse());
        return repository.save(record);
    }

    /**
     * Delete a session
     * @param id
     */
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * Get the list of all sessions
     * @return [CourseSession]
     */
    public List<CourseSession> findAll(){
        return repository.findAll();
    }

    /**
     * Get a specific session by its ID
     * @param id
     * @return CourseSession
     */
    public CourseSession findById(Long id){
        return repository.findById(id).get();
    }

    /**
     * Get a list of courses by title
     * @param courseTitle
     * @return [CourseSession]
     */
    public List<CourseSession> getCourseByFilterCourse(String courseTitle) {
        return  repository.findByCourse_Title(courseTitle);
    }

    /**
     * Get a list of courses by title, and
     * @param courseTitle
     * @return [CourseSession]
     */
    public List<CourseSession> getCourseByFilterCourseAndDate(String courseTitle, Date startDate, Date endDate) {
        return  repository.findByCourse_TitleAndStartDateBeforeAndEndDateAfter(courseTitle, startDate, endDate);
    }
    public List<CourseSession> getCourseByFilterCourseAndLocation(String courseTitle, String city) {
        return  repository.findByCourse_TitleAndLocation_City(courseTitle, city);
    }
    public List<CourseSession> getCourseByFilterAll(String course,Date startDate, Date endDate,  String city) {
        return repository.findByCourse_TitleAndStartDateBeforeAndEndDateAfterAndLocation_City(course,startDate,endDate,city);
    }
}
