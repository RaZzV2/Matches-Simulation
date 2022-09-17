package com.example.javapentalog.SecondModule.services;

import com.example.javapentalog.SecondModule.repository.competitors.Competitor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CompetitorService {

    Competitor addCompetitor(@Valid Competitor competitor);

    Competitor getCompetitorById(@NotNull Integer id);

    Competitor getCompetitorByName(@NotNull String name);

    Competitor updateCompetitorById(@NotNull Integer id, @Valid Competitor competitor);

    Competitor patchCompetitorById(@NotNull Integer id, Competitor competitor);

    List<Competitor> findAllCompetitors();

    void deleteCompetitorById(@NotNull Integer id);

}
