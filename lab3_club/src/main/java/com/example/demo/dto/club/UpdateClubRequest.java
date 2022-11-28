package com.example.demo.dto.club;

import com.example.demo.entities.Club;
import lombok.*;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class UpdateClubRequest {
    private double budget;

    public static Function<UpdateClubRequest, Club> dtoToEntityMapper(Supplier<Club> clubSupplier){
        return request -> clubSupplier.get().toBuilder()
                .budget(request.getBudget())
                .build();
    }
}
