package com.example.javapentalog.SecondModule.repository.competitors;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompetitorRepository extends CrudRepository<Competitor,Integer> {
    Optional<Competitor> findByName (String name);
}
