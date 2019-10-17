package com.lo54.project.service;

import com.lo54.project.model.Course;
import com.lo54.project.model.CourseSession;
import com.lo54.project.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
/**
 * Course business layer
 */
public class CourseService {
    private final CourseRepository repository;

    /**
     * Add new course
     * @param course
     * @return Course
     */
    public Course create(Course course){
        return repository.save(course);
    }

    /**
     * Update an existing course
     * @param course
     * @return Course
     */
    public Course update(Course course){
        Course record = repository.findById(course.getIdCourse()).get();
        record.setCodeCourse(course.getCodeCourse());
        record.setTitle(course.getTitle());
        record.setLocation(course.getLocation());
        return repository.save(record);
    }

    /**
     * Delete a course
     * @param id
     * @return Boolean
     */
    public Boolean delete(Long id){
        repository.deleteById(id);
        return true;
    }

    /**
     * Get the list of all courses
     * @return [Course]
     */
    public List<Course> findAll(){
        return repository.findAll();
    }

    /**
     * Get a specific course by its ID
     * @param id
     * @return Course
     */
    public Course findById(Long id){
        return repository.findById(id).get();
    }

    /**
     * Get the list of courses which contain a string in their titles
     * @param keyword
     * @return [Course]
     */
    public List<Course> findByTitleContaining(String keyword){
        return repository.findByTitleContaining(keyword);
    }

    /**
     * Get the list of courses by a location ID
     * @param location
     * @return [Course]
     */
    public List<Course> findCoursesByLocation_IdLocation(Long location) { return  repository.findCoursesByLocation_IdLocation(location); }

    /**
     * Get the list of courses which have available sessions in a given date
     * @param date
     * @return [Course]
     */
    public List<Course> findByDate(Date date) {
        return repository.findByDate(date);

    }

}
