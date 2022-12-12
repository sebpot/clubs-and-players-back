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
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Player> players;
}
