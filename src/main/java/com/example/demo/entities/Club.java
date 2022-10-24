package com.example.demo.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Club {
    private String name;
    private double budget;
    private int yearFounded;
}
