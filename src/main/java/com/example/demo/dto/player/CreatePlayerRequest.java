package com.example.demo.dto.player;

import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import lombok.*;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CreatePlayerRequest {
    private String name;
    private int age;
    private String clubName;

    public static Function<CreatePlayerRequest, Player> dtoToEntityMapper(Supplier<Club> supplier){
        return request -> Player.builder()
                .name(request.getName())
                .age(request.getAge())
                .club(supplier.get())
                .build();
    }
}
