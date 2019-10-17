package com.lo54.project.service;
import com.lo54.project.model.Location;
import com.lo54.project.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
/**
 * Location business layer
 */
public class LocationService {


    private final LocationRepository repository;

    /**
     * Add new location
     */
    public Location create(Location location){
        return repository.save(location);
    }

    /**
     * Update an existing location
     * @param location
     * @return Location
     */
    public Location update(Location location){
        Location record = repository.findById(location.getIdLocation()).get();
        record.setCity(location.getCity());
        return repository.save(record);
    }

    /**
     * Delete a location
     * @param id
     * @return Boolean
     */
    public Boolean delete(Long id){ repository.deleteById(id); return true; }

    /**
     * Get the list of all existing locations
     * @return [Location]
     */
    public List<Location> findAll(){
        return repository.findAll();
    }

    /**
     * Get a location by its ID
     * @param id
     * @return Location
     */
    public Location findById(Long id){
        return repository.findById(id).get();
    }
}
