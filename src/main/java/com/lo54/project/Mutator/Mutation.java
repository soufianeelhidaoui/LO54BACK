package com.lo54.project.Mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lo54.project.model.Client;
import com.lo54.project.model.Course;
import com.lo54.project.model.Location;
import com.lo54.project.service.ClientService;
import com.lo54.project.service.CourseService;
import com.lo54.project.service.CourseSessionService;
import com.lo54.project.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final LocationService locationService;
    private final CourseService courseService;
    private final ClientService clientService;
    private final CourseSessionService courseSessionService;

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
    public Course newCourse(String codeCourse, String title){
        Course course = new Course();
        course.setCodeCourse(codeCourse);
        course.setTitle(title);
        return courseService.create(course);
    }
    public Course updateCourse(Long id, String codeCourse, String title){
        Course course = courseService.findById(id);
        course.setCodeCourse(codeCourse);
        course.setTitle(title);
        return courseService.update(course);
    }
    public Boolean deleteCourse(Long id){
        return courseService.delete(id);
    }

    //Clients
    public Client CreateClient(String lastName, String firstName, String address, String phone, String email, Long courseSessionId) {
        return clientService.createClient(lastName,firstName,address,phone,email,courseSessionId);
    }
}
