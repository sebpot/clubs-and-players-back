package com.example.demo.dto.player;

import com.example.demo.entities.Player;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetPlayersResponse {
    @Singular
    private List<String> players;

    public static Function<Collection<Player>, GetPlayersResponse> entityToDtoMapper() {
        return players -> {
            GetPlayersResponseBuilder response = GetPlayersResponse.builder();
            players.stream()
                    .map(Player::getName)
                    .forEach(response::player);
            return response.build();
        };
    }
}
