package com.example.demo.services;

import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import com.example.demo.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void save(Player p){
        playerRepository.save(p);
    }

    public Optional<Player> findById(String name){
        return playerRepository.findById(name);
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public List<Player> findAllByCategory(Club club){
        return playerRepository.findAllByClub(club);
    }

    public void delete(Player p){
        playerRepository.delete(p);
    }
}
