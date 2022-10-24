package com.example.demo.services;

import com.example.demo.entities.Player;
import com.example.demo.repos.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public void saveByService(Player p){
        playerRepo.save_new_object(p);
    }

    public Optional<Player> findByIndexByService(String name){
        return playerRepo.findById(name);
    }

    public List<Player> findAllByService(){
        return playerRepo.findAll();
    }

    public void deleteBYService(Player p){
        playerRepo.delete(p);
    }
}
