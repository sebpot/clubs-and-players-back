package com.example.demo.services;

import com.example.demo.entities.Club;
import com.example.demo.repos.ClubRepository;
import com.example.demo.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EventRepository eventRepository;

    public void save(Club c){
        clubRepository.save(c);
        eventRepository.save(c);
    }

    public Optional<Club> findById(String name){
        return clubRepository.findById(name);
    }

    public List<Club> findAll(){
        return clubRepository.findAll();
    }

    public void delete(Club c){
        clubRepository.delete(c);
        eventRepository.delete(c);
    }
}
