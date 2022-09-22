package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matches.MatchRepository;
import com.example.javapentalog.SecondModule.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor

public class MatchServiceImpl  implements MatchService {
    private final MatchRepository matchRepository;


    @Override
    public Match addMatch(@Valid Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void save(Match match){
        matchRepository.save(match);
    }
    @Override
    public Match getMatchById(@NotNull Integer id) {
        return matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Override
    public Match getMatchByName(@NotNull String name) {
        return matchRepository.findByMatchName(name).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Override
    public Match updateMatchById(@NotNull Integer id, @Valid Match match) {
        Match matchToUpdate = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        matchToUpdate.setMatchName(match.getMatchName());
        matchToUpdate.setPrize(match.getPrize());
        return matchRepository.save(matchToUpdate);
    }

    @Override
    public Match patchMatchById(Integer id, Match match) {
        Match matchToUpdate = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        if (match.getMatchName() != null) {
            matchToUpdate.setMatchName(match.getMatchName());
        }
        if (match.getPrize() != null) {
            matchToUpdate.setPrize(match.getPrize());
        }

        return matchRepository.save(matchToUpdate);
    }

    @Override
    public List<Match> findAllMatches(PageRequestTest pageRequestTest) {
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public void deleteMatchById(@NotNull Integer id) {
        matchRepository.deleteById(id);
    }
}
