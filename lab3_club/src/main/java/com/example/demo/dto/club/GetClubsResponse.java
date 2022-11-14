package com.example.demo.dto.club;

import com.example.demo.dto.player.GetPlayersResponse;
import com.example.demo.entities.Club;
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
public class GetClubsResponse {
    @Singular
    private List<String> clubs;

    public static Function<Collection<Club>, GetClubsResponse> entityToDtoMapper() {
        return clubs -> {
            GetClubsResponse.GetClubsResponseBuilder response = GetClubsResponse.builder();
            clubs.stream()
                    .map(Club::getName)
                    .forEach(response::club);
            return response.build();
        };
    }
}
