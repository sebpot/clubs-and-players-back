package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@Entity
@Table(name="players")
public class Player {
    @Id
    private String name;
    @Column(name="age")
    private int age;
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;
}
