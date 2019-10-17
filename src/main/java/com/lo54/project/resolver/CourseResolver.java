package com.lo54.project.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lo54.project.model.Course;
import com.lo54.project.model.Location;
import com.lo54.project.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseResolver implements GraphQLResolver<Course> {

    private final LocationService locationService;

    public Location location(Course course){ return locationService.findById(course.getLocation().getIdLocation()); }


}
