package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.competitors.CompetitorRepository;
import com.example.javapentalog.SecondModule.services.CompetitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class CompetitorServiceImpl implements CompetitorService {

    private final CompetitorRepository competitorRepository;


    @Override
    public Competitor addCompetitor(@Valid Competitor competitor) {
        return competitorRepository.save(competitor);
    }

    @Override
    public Competitor getCompetitorById(@NotNull Integer id) {
        return competitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Competitor not found"));
    }
    @Override
    public Competitor getCompetitorByName(@NotNull String name) {
        return competitorRepository.findByName(name).orElseThrow(() -> new RuntimeException("Competitor not found"));
    }

    @Override
    public Competitor updateCompetitorById(@NotNull Integer id, @Valid Competitor competitor) {
        Competitor competitorToUpdate = competitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competitor not found"));
        competitorToUpdate.setName(competitor.getName());
        competitorToUpdate.setAge(competitor.getAge());
        return competitorRepository.save(competitorToUpdate);
    }

    @Override
    public void save(Competitor competitor){
        competitorRepository.save(competitor);
    }
    @Override
    public Competitor patchCompetitorById(@NotNull Integer id, @Valid Competitor competitor) {
        Competitor competitorToUpdate = competitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competitor not found"));

        if (competitor.getName() != null) {
            competitorToUpdate.setName(competitor.getName());
        }
        if (competitor.getAge() != null) {
            competitorToUpdate.setAge(competitor.getAge());
        }

        return competitorRepository.save(competitorToUpdate);
    }

    @Override
    public Page<Competitor> findAllCompetitors(PageRequestTest pageRequestTest) {
        //return (List<Competitor>) competitorRepository.findAll();
        final var pageable = PageRequest.of(pageRequestTest.getPage(), pageRequestTest.getSize(), Sort.by("id"));
        return competitorRepository.findAll(pageable);
    }

    @Override
    public void deleteCompetitorById(@NotNull Integer id) {
        competitorRepository.deleteById(id);
    }
}
