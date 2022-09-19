package com.example.javapentalog.SecondModule.services;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CompetitorService {

    Competitor addCompetitor(@Valid Competitor competitor);

    Competitor getCompetitorById(@NotNull Integer id);

    Competitor getCompetitorByName(@NotNull String name);

    Competitor updateCompetitorById(@NotNull Integer id, @Valid Competitor competitor);

    void save(Competitor competitor);

    Competitor patchCompetitorById(@NotNull Integer id, Competitor competitor);

    Page<Competitor> findAllCompetitors(PageRequestTest pageRequestTest);

    void deleteCompetitorById(@NotNull Integer id);

}
