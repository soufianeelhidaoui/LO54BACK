package com.lo54.project;

import com.lo54.project.model.Location;
import com.lo54.project.repository.LocationRepository;
import com.lo54.project.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

    @Autowired
    private LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;

    @Test
    public void getLocationsTest(){
        when(locationRepository.findAll()).thenReturn(Stream.of(
                new Location(1L,"Belfort"), new Location(2L,"Mulhouse")).collect(Collectors.toList()));
        assertEquals(2, locationService.findAll().size());

    }
}
