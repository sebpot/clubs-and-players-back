package com.example.demo.dto.club;

import com.example.demo.dto.player.GetPlayerResponse;
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
public class GetClubResponse {
    private String name;
    private double budget;
    private int yearFounded;

    public static Function<Club, GetClubResponse> entityToDtoMapper() {
        return club -> GetClubResponse.builder()
                .name(club.getName())
                .budget(club.getBudget())
                .yearFounded(club.getYearFounded())
                .build();
    }
}
