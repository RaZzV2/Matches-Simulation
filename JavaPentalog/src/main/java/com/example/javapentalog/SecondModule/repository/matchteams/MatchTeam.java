package com.example.javapentalog.SecondModule.repository.matchteams;


import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MatchTeam matchTeam = (MatchTeam) o;
        return id != null && Objects.equals(id, matchTeam.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

