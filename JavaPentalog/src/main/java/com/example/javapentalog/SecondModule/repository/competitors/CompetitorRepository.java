package com.example.javapentalog.SecondModule.repository.competitors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompetitorRepository extends PagingAndSortingRepository<Competitor,Integer> {
    Optional<Competitor> findByName (String name);
}
