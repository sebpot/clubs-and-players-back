package com.example.demo.dto.club;

import com.example.demo.entities.Club;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateClubEvent {
    private String name;

    public static Function<Club, CreateClubEvent> dtoToEntityMapper(){
        return club -> CreateClubEvent.builder()
                .name(club.getName())
                .build();
    }
}
