package com.example.demo.services;

import com.example.demo.entities.Club;
import com.example.demo.repos.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepo clubRepo;

    public void saveByService(Club c){
        clubRepo.save_new_object(c);
    }

    public Optional<Club> findByIndexByService(String name){
        return clubRepo.findById(name);
    }

    public List<Club> findAllByService(){
        return clubRepo.findAll();
    }

    public void deleteByService(Club c){
        clubRepo.delete(c);
    }
}
