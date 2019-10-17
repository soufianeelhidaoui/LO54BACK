package com.lo54.project.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lo54.project.model.Course;
import com.lo54.project.model.Location;
import com.lo54.project.service.CourseService;
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

    public List<Location> getLocations(){ return  locationService.findAll(); }
    public Location getLocation(Long id){ return locationService.findById(id); }

    public List<Course> getCourses(){ return  courseService.findAll(); }
    public Course getCourse(Long id){ return courseService.findById(id); }
    public List<Course> getCourseByTitle(String title){ return courseService.findByTitleContaining(title); }
    public List<Course> getCourseByLocation(Long idLocation){ return courseService.findCoursesByLocation_IdLocation(idLocation); }
    public List<Course> getCourseByAvailability(Date date){ return courseService.findByDate(date);}
}
