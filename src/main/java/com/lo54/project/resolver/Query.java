package com.lo54.project.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lo54.project.model.Client;
import com.lo54.project.model.Course;
import com.lo54.project.model.CourseSession;
import com.lo54.project.model.Location;
import com.lo54.project.service.ClientService;
import com.lo54.project.service.CourseService;
import com.lo54.project.service.CourseSessionService;
import com.lo54.project.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final LocationService locationService;
    private final CourseService courseService;
    private final ClientService clientService;
    private final CourseSessionService courseSessionService;

    //Query of Location Service
    public List<Location> getLocations(){ return  locationService.findAll(); }
    public Location getLocation(Long id){ return locationService.findById(id); }

    //Query of Course Service
    public List<Course> getCourses(){ return  courseService.findAll(); }
    public Course getCourse(Long id){ return courseService.findById(id); }

    //Query of Client Service
    public List<Client> getClients(){ return  clientService.findAll(); }
    public Client getClient(Long id){ return clientService.findById(id); }

    //Query of CourseSession Service
    public List<CourseSession> getCourseSessions() {
        return courseSessionService.findAll();
    }
    public CourseSession getCourseSession(long id) {
        return courseSessionService.findById(id);
    }
    public List<CourseSession> getCourseByFilterCourse(String courseTitle) { return this.courseSessionService.getCourseByFilterCourse(courseTitle); }
    public List<CourseSession> getCourseByFilterCourseAndDate(String courseTitle, Date startDate, Date endDate) { return this.courseSessionService.getCourseByFilterCourseAndDate(courseTitle, startDate, endDate); }
    public List<CourseSession> getCourseByFilterCourseAndLocation(String courseTitle, String city) { return this.courseSessionService.getCourseByFilterCourseAndLocation(courseTitle, city); }
    public List<CourseSession> getCourseByFilterAll(String courseTitle, Date startDate, Date endDate,  String city) { return courseSessionService.getCourseByFilterAll(courseTitle,startDate,endDate,city); }
}
