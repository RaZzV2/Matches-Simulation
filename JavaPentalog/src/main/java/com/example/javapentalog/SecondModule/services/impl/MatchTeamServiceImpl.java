package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.PlannedMatch;
import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matches.MatchRepository;
import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;
import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeamRepository;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.repository.teams.TeamRepository;
import com.example.javapentalog.SecondModule.services.MatchService;
import com.example.javapentalog.SecondModule.services.MatchTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;


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
                if(aux.getMatchField().equals(matchTeam.getMatchField()) && aux.getTeamField().equals(matchTeam.getTeamField())) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                    matchTeamRepository.save(matchTeam);
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
    public List<PlannedMatch> findMatchesByDescOrder(PageRequestTest pageRequestTest){
        Comparator<MatchTeam> compareByMatch = (MatchTeam o1, MatchTeam o2) ->o1.getMatchField().getId().compareTo(o2.getMatchField().getId());
        List<MatchTeam> matchTeams = (List<MatchTeam>) matchTeamRepository.findAll();
        matchTeams.sort(compareByMatch);
        List<PlannedMatch> plannedMatches = new ArrayList<>();
        int n = matchTeams.size();
        if(n%2==1)
            n--;
            for (int index = 0; index < n; index += 2) {
                PlannedMatch plannedMatch = null;
                plannedMatch = new PlannedMatch(matchTeams.get(index), matchTeams.get(index + 1));
                plannedMatches.add(plannedMatch);
            }
          return plannedMatches;
    }

    public List<MatchTeam> simulateMatches() {
        List<MatchTeam> all = (List<MatchTeam>) matchTeamRepository.findAll();
        for(MatchTeam aux : all){
            updateMatchTeamById(aux.getId());
        }
        return all;
    }

    @Override
    public MatchTeam updateMatchTeamById(@NotNull Integer id){
        MatchTeam matchTeamToUpdate = matchTeamRepository.findById(id).orElseThrow(() -> new RuntimeException("Planned match is not valid"));
        Random random = new Random();
        int x = random.nextInt(9);
        matchTeamToUpdate.setScore(x);
        return matchTeamRepository.save(matchTeamToUpdate);
    }

    @Override
    public MatchTeam getMatchTeamById(Integer id) {
        return matchTeamRepository.findById(id).orElseThrow(() -> new RuntimeException("Planned match not found"));
    }
}
