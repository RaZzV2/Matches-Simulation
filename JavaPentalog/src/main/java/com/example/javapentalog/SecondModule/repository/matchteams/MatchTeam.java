package com.example.javapentalog.SecondModule.repository.matchteams;


import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "match_team")

public class MatchTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_team_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "team_id")
    private Team teamField;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "match_id")
    private Match matchField;

    private Integer score;
}
