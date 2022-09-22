package com.example.javapentalog.SecondModule.repository.teams;

import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@RequiredArgsConstructor
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Team team = (Team) o;
        return id != null && Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
