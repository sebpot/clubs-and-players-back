package com.example.demo;

import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import com.example.demo.services.ClubService;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    @Autowired
    private ClubService clubService;
    @Autowired
    private PlayerService playerService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nAvailable actions:\nC - list clubs\nP - list players\n" +
                "A - add new element\nD - delete existing element\nS - stop the application");
        boolean stopped = false;
        while(scan.hasNext() && !stopped){
            String input = scan.next();
            switch (input){
                case "C":
                    System.out.println("Clubs:");
                    for(Club c : clubService.findAllByService()){
                        System.out.println(" - " + c.toString());
                    }
                    break;
                case "P":
                    System.out.println("Players:");
                    for(Player p : playerService.findAllByService()){
                        System.out.println(" - " + p.toString());
                    }
                    break;
                case "A":
                    try{
                        System.out.println("Name:");
                        String name = scan.next();
                        System.out.println("Age:");
                        int age = scan.nextInt();
                        System.out.println("Club name:");
                        String club = scan.next();
                        Club c = clubService.findByIndexByService(club).get();
                        Player p = new Player(name, age, c);
                        playerService.saveByService(p);
                        System.out.println("Added a player: "+p);
                    }
                    catch(Exception ignored) {
                        System.out.println("Bad input!!!");
                    }
                    break;
                case "D":
                    try {
                        System.out.println("Name:");
                        String name = scan.next();
                        Player p = playerService.findByIndexByService(name).get();
                        playerService.deleteBYService(p);
                        System.out.println("Deleted a player: "+p);
                    }catch(Exception ignored){
                        System.out.println("Bad input!!!");
                    }
                    break;
                case "S":
                    stopped = true;
                    break;
            }
        }

    }
}
