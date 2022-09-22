package com.example.javapentalog.SecondModule.repository.teams;

import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Accessors(chain = true)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Integer id;

    @Column(unique = true)
    private String teamName;

    private String description;


    @OneToMany(mappedBy="teamField", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MatchTeam> matchTeams = new ArrayList<>();





}
