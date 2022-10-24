package com.example.demo.repos;

import com.example.demo.Storage;
import com.example.demo.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepo {

    @Autowired
    public Storage storage;

    public void save_new_object(Player p){
        storage.players.add(p);
    }

    public Optional<Player> findById(String name){
        return storage.players.stream().filter((Player player) -> player.getName().equals(name)).findFirst();
    }

    public List<Player> findAll(){
        return storage.players;
    }

    public void delete(Player p){
        storage.players.remove(p);
    }
}
