package com.example.demo.repos;

import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    List<Player> findAllByClub(Club club);

}
