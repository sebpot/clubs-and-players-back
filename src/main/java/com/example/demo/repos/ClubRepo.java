package com.example.demo.repos;

import com.example.demo.Storage;
import com.example.demo.entities.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClubRepo {

    @Autowired
    public Storage storage;

    public void save_new_object(Club c){
        storage.clubs.add(c);
    }

    public Optional<Club> findById(String name){
        return storage.clubs.stream().filter((Club club) -> club.getName().equals(name)).findFirst();
    }

    public List<Club> findAll(){
        return storage.clubs;
    }

    public void delete(Club c){
        storage.clubs.remove(c);
    }
}
