package com.example.javapentalog.SecondModule.repository.matches;

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
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private Integer id;

    private String matchName;

    private String prize;

    @OneToMany(mappedBy="matchField", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MatchTeam> matchTeams = new ArrayList<>();

}
