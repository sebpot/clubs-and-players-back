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
public class CreateClubRequest {
    private String name;
    private double budget;
    private int yearFounded;

    public static Function<CreateClubRequest, Club> dtoToEntityMapper() {
        return request -> Club.builder()
                .name(request.getName())
                .budget(request.getBudget())
                .yearFounded(request.getYearFounded())
                .build();
    }
}
