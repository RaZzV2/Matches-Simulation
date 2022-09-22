package com.example.javapentalog.SecondModule.repository.matches;

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
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private Integer id;

    private String matchName;

    private String prize;

    @OneToMany(mappedBy="matchField", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MatchTeam> matchTeams = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Match match = (Match) o;
        return id != null && Objects.equals(id, match.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
