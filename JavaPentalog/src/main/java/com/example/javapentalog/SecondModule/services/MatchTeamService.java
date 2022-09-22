package com.example.javapentalog.SecondModule.services;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;

import javax.validation.Valid;
import java.util.List;

public interface MatchTeamService {

    void save(@Valid MatchTeam matchTeam);

    MatchTeam addMatchTeam(@Valid MatchTeam matchTeam);

    List<MatchTeam> findAllMatchTeam(PageRequestTest pageRequestTest);

    MatchTeam getMatchTeamById(@Valid Integer id);
}
