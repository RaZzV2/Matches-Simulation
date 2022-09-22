package com.example.javapentalog.SecondModule.repository.matches;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchRepository extends CrudRepository<Match,Integer> {
    Optional<Match> findByMatchName (String matchName);

}
