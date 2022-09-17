package com.example.javapentalog.SecondModule.repository.teams;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team,Integer> {
    Optional<Team> findByTeamName(String teamName);
}
