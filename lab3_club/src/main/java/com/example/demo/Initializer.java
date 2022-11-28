package com.example.demo;

import com.example.demo.entities.Club;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    @Autowired
    private ClubService clubService;

    @PostConstruct
    public void init() throws Exception {
        Club club = new Club();
        club.setName("Real Madryt");
        club.setBudget(105.5);
        club.setYearFounded(1902);
        clubService.save(club);

        club = new Club();
        club.setName("Barcelona");
        club.setBudget(34.5);
        club.setYearFounded(1899);
        clubService.save(club);

        club = new Club();
        club.setName("Arsenal");
        club.setBudget(30);
        club.setYearFounded(1878);
        clubService.save(club);
    }

}
