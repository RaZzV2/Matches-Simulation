package com.example.javapentalog.SecondModule.repository.competitors;

import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity

public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String team;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getAge() {
        return age;
    }
}
