package com.example.demo;

import com.example.demo.entities.Player;
import com.example.demo.entities.Club;
import com.example.demo.services.PlayerService;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Initializer {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ClubService clubService;

    @PostConstruct
    public void init() throws Exception {
        Club club = new Club("Real Madryt", 105.5, 1902);

        clubService.saveByService(club);
        playerService.saveByService(new Player("Toni Kroos", 32, club));
        playerService.saveByService(new Player("Luka Modrić", 37, club));

        club = new Club("Barcelona", 34.5, 1899);
        clubService.saveByService(club);
        playerService.saveByService(new Player("Robert Lewandowski", 34, club));

        club = new Club("Arsenal", 30, 1878);
        clubService.saveByService(club);
        playerService.saveByService(new Player("Gabriel Jesus", 25, club));

    }

}
