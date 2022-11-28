package com.example.demo.controllers;

import com.example.demo.dto.club.CreateClubRequest;
import com.example.demo.entities.Club;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private ClubService clubService;

    @PostMapping()
    public ResponseEntity<Void> createClub(@RequestBody CreateClubRequest request){
        Club club = CreateClubRequest.dtoToEntityMapper().apply(request);
        clubService.save(club);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteClub(@PathVariable String name){
        Optional<Club> clubOpt = clubService.findById(name);
        if(clubOpt.isPresent()){
            clubService.delete(clubOpt.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
