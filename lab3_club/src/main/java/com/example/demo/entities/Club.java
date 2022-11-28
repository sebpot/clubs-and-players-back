package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@Entity
@Table(name="clubs")
public class Club {
    @Id
    private String name;

    @Column(name="budget")
    private double budget;

    @Column(name="year_of_foundation")
    private int yearFounded;
}
