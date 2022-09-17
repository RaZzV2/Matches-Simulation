package com.example.javapentalog.SecondModule.services;

import com.example.javapentalog.SecondModule.repository.matches.Match;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface MatchService {

    Match addMatch(@Valid Match match);

    Match getMatchById(@NotNull Integer id);

    Match getMatchByName(@NotNull String name);

    Match updateMatchById(@NotNull Integer id, @Valid Match match);

    Match patchMatchById(@NotNull Integer id, @Valid Match match);

    List<Match> findAllMatches();

    void deleteMatchById(@NotNull Integer id);
}
