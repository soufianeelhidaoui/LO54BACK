package com.lo54.project.service;

import com.lo54.project.model.Client;
import com.lo54.project.model.CourseSession;
import com.lo54.project.repository.ClientRepository;
import com.lo54.project.repository.CourseSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
/**
 * Client business layer
 */
public class ClientService {
    private final ClientRepository repository;

    /**
     * Add new client
     * @param client
     * @return Client
     */
    public Client create(Client client){
        return repository.save(client);
    }

    /**
     * Update an existing client
     * @param client
     * @return Client
     */
    public Client update(Client client){
        Client record = repository.findById(client.getIdClient()).get();
        record.setFirstName(client.getFirstName());
        record.setLastName(client.getLastName());
        record.setAddress(client.getAddress());
        record.setPhone(client.getPhone());
        record.setEmail(client.getEmail());
        record.setCourseSessions(client.getCourseSessions());
        return repository.save(record);
    }

    /**
     * Delete a client
     * @param id
     */
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * Get the list of all clients
     * @return [Client]
     */
    public List<Client> findAll(){
        return repository.findAll();
    }

    /**
     * Get a client by his ID
     * @param id
     * @return Client
     */
    public Client findById(Long id){
        return repository.findById(id).get();
    }

    /**
     * Register a client in a session
     * @param idClient
     * @param courseSession
     * @return Client
     */
    public Client registerInSession(Long idClient, CourseSession courseSession){
        Client record = repository.findById(idClient).get();
        record.getCourseSessions().add(courseSession);
        return repository.save(record);
    }
}
