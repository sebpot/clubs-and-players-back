package com.example.demo.dto.player;

import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetPlayerResponse {
    private String name;
    private int age;
    private Club club;

    public static Function<Player, GetPlayerResponse> entityToDtoMapper() {
        return player -> GetPlayerResponse.builder()
                .name(player.getName())
                .age(player.getAge())
                .club(player.getClub())
                .build();
    }
}
