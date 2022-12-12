package com.example.demo.controllers;

import com.example.demo.dto.club.CreateClubRequest;
import com.example.demo.dto.club.GetClubResponse;
import com.example.demo.dto.club.GetClubsResponse;
import com.example.demo.dto.club.UpdateClubRequest;
import com.example.demo.entities.Club;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping()
    public ResponseEntity<GetClubsResponse> readClubs(){
        return ResponseEntity.ok(GetClubsResponse.entityToDtoMapper().apply(clubService.findAll()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<GetClubResponse> getClub(@PathVariable String name){
        Optional<Club> clubOpt = clubService.findById(name);
        if(clubOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GetClubResponse.entityToDtoMapper().apply(clubOpt.get()));
    }

    @PostMapping()
    public ResponseEntity<Void> createClub(@RequestBody CreateClubRequest request){
        Club club = CreateClubRequest.dtoToEntityMapper().apply(request);
        if(club.getName().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        clubService.save(club);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updateClub(@RequestBody UpdateClubRequest request, @PathVariable String name){
        Optional<Club> clubOpt = clubService.findById(name);
        if(clubOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Club updated = UpdateClubRequest.dtoToEntityMapper(clubOpt::get).apply(request);
        clubService.save(updated);
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
