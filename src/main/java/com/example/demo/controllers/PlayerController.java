package com.example.demo.controllers;

import com.example.demo.dto.player.CreatePlayerRequest;
import com.example.demo.dto.player.GetPlayerResponse;
import com.example.demo.dto.player.GetPlayersResponse;
import com.example.demo.dto.player.UpdatePlayerRequest;
import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import com.example.demo.services.ClubService;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ClubService clubService;

    @GetMapping()
    public ResponseEntity<GetPlayersResponse> readPlayers(){
        return ResponseEntity.ok(GetPlayersResponse.entityToDtoMapper().apply(playerService.findAll()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<GetPlayerResponse> getPlayer(@PathVariable String name){
        Optional<Player> playerOpt = playerService.findById(name);
        if(playerOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GetPlayerResponse.entityToDtoMapper().apply(playerOpt.get()));
    }

    @PostMapping()
    public ResponseEntity<Void> createPlayer(@RequestBody CreatePlayerRequest request){
        Optional<Club> clubOpt = clubService.findById(request.getClubName());
        Player player = CreatePlayerRequest.dtoToEntityMapper(clubOpt::get).apply(request);
        playerService.save(player);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updatePlayer(@RequestBody UpdatePlayerRequest request,@PathVariable String name){
        Optional<Player> playerOpt = playerService.findById(name);
        if(playerOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Optional<Club> clubOpt = clubService.findById(request.getClubName());
        if(clubOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Player updated = UpdatePlayerRequest.dtoToEntityMapper(playerOpt::get, clubOpt::get).apply(request);
        playerService.save(updated);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String name){
        Optional<Player> playerOpt = playerService.findById(name);
        if(playerOpt.isPresent()){
            playerService.delete(playerOpt.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
