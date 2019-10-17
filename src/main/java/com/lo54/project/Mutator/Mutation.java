package com.lo54.project.Mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lo54.project.model.Course;
import com.lo54.project.model.Location;
import com.lo54.project.service.CourseService;
import com.lo54.project.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final LocationService locationService;
    private final CourseService courseService;

    //Locations
    public Location newLocation(String city){
        Location location = new Location();
        location.setCity(city);
        return locationService.create(location);
    }
    public Location updateLocation(Long id, String city){
        Location location = locationService.findById(id);
        location.setCity(city);
        return locationService.update(location);
    }
    public Boolean deleteLocation(Long id){
        return locationService.delete(id);
    }
    
    //Courses
    public Course newCourse(String codeCourse, String title, Long location){
        Course course = new Course();
        course.setCodeCourse(codeCourse);
        course.setTitle(title);
        course.setLocation(locationService.findById(location));
        return courseService.create(course);
    }
    public Course updateCourse(Long id, String codeCourse, String title, Long location){
        Course course = courseService.findById(id);
        course.setCodeCourse(codeCourse);
        course.setTitle(title);
        course.setLocation(locationService.findById(location));
        return courseService.update(course);
    }
    public Boolean deleteCourse(Long id){
        return courseService.delete(id);
    }

}
