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
public class UpdatePlayerRequest {
    private int age;
    private String clubName;

    public static Function<UpdatePlayerRequest, Player> dtoToEntityMapper(Supplier<Player> playerSupplier, Supplier<Club> supplier){
        return request -> playerSupplier.get().toBuilder()
                .age(request.getAge())
                .club(supplier.get())
                .build();
    }
}
