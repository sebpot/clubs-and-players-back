package com.example.demo.repos;

import com.example.demo.dto.club.CreateClubEvent;
import com.example.demo.entities.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EventRepository {

    @Autowired @Qualifier("players")
    private RestTemplate restTemplate;

    public void delete(Club club){
        restTemplate.delete("/"+club.getName());
    }

    public void save(Club club){
        restTemplate.postForEntity("/", CreateClubEvent.dtoToEntityMapper().apply(club), Void.class);
    }
}
