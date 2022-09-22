package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matches.MatchRepository;
import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;
import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeamRepository;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.repository.teams.TeamRepository;
import com.example.javapentalog.SecondModule.services.MatchTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MatchTeamServiceImpl implements MatchTeamService {

    private final MatchTeamRepository matchTeamRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Override
    public void save(MatchTeam matchTeam) {
        Match match = matchRepository.findByMatchName(matchTeam.getMatchField().getMatchName()).orElse(null);
        Team team = teamRepository.findByTeamName(matchTeam.getTeamField().getTeamName()).orElse(null);
        if(match != null && team!= null) {
            matchTeam.setScore(-1);
            matchTeam.setMatchField(match);
            matchTeam.setTeamField(team);
            List<MatchTeam> matchTeams = (List<MatchTeam>) matchTeamRepository.findAll();
            boolean duplicate=false;
            for(MatchTeam aux : matchTeams){
                if(aux.getMatchField().equals(matchTeam.getMatchField()) && aux.getTeamField().equals(matchTeam.getTeamField()))
                    duplicate=true;

            }
            if (!duplicate) {
                long teamNumber = matchTeams.stream().filter(c -> c.getMatchField().getId().equals(matchTeam.getMatchField().getId())).count();
                if (teamNumber <= 2) {
                    matchTeamRepository.save(matchTeam);
                }
            }
        }
    }

    @Override
    public MatchTeam addMatchTeam(MatchTeam matchTeam) {
        return null;
    }

    @Override
    public List<MatchTeam> findAllMatchTeam(PageRequestTest pageRequestTest) {
        return (List<MatchTeam>) matchTeamRepository.findAll();
    }

    @Override
    public MatchTeam getMatchTeamById(Integer id) {
        return matchTeamRepository.findById(id).orElseThrow(() -> new RuntimeException("Planned match not found"));
    }
}
