package com.example.demo;

import com.example.demo.entities.Player;
import com.example.demo.entities.Club;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class Storage {
    public List<Player> players = new LinkedList<>();
    public List<Club> clubs = new LinkedList<>();
}
