package com.example.javapentalog.SecondModule.repository.teams;

import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Data
@Accessors(chain = true)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String teamName;

    private String description;

    @OneToMany
    private List<Competitor> competitors;

    @OneToMany
    private List<Match> matches;

}
