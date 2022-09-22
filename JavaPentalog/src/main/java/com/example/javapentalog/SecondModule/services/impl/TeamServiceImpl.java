package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.competitors.CompetitorRepository;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matches.MatchRepository;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.repository.teams.TeamRepository;
import com.example.javapentalog.SecondModule.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final CompetitorRepository competitorRepository;

    private final MatchRepository matchRepository;

    @Override
    public Team addTeam(@Valid Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    /*@Override
    public Team addMatchToTeam(Integer teamId, Integer matchId) {
        Team actualTeam = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        Optional<Match> byId = matchRepository.findById(matchId);
        if(byId.isPresent()) {
            actualTeam.getMatchList().add(matchRepository.findById(matchId).get());
        }
        return teamRepository.save(actualTeam);
    }*/

    @Override
    public Team removeMatchFromTeam(String teamName, String matchName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow(() -> new RuntimeException("Team not found"));
        Match actualMatch = matchRepository.findByMatchName(matchName).orElseThrow(() -> new RuntimeException("Match not found"));
        return teamRepository.save(actualTeam);
    }

    @Override
    public Team addCompetitorToTeam(String teamName, String competitorName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow( () -> new RuntimeException("Team not found"));
        Competitor actualCompetitor = competitorRepository.findByName(competitorName).orElseThrow( () -> new RuntimeException("Competitor not found"));
        return teamRepository.save(actualTeam);
    }
    @Override
    public Team removeCompetitorFromTeam(String teamName, String competitorName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow( () -> new RuntimeException("Team not found"));
        Competitor actualCompetitor = competitorRepository.findByName(competitorName).orElseThrow( () -> new RuntimeException("Competitor not found"));
        return teamRepository.save(actualTeam);
    }



    @Override
    public Team getTeamById(@NotNull Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public Team getTeamByName(@NotNull String name) {
        return teamRepository.findByTeamName(name).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Override
    public Team updateTeamById(@NotNull Integer id, @Valid Team team) {
        Team teamToUpdate = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        teamToUpdate.setDescription(team.getDescription());
        return teamRepository.save(team);
    }

    @Override
    public Team patchTeamById(@NotNull Integer id, @Valid Team team) {
        Team teamToUpdate = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        if(teamToUpdate.getTeamName() != null)
            teamToUpdate.setTeamName(team.getTeamName());
        if(teamToUpdate.getDescription() != null)
            teamToUpdate.setDescription(team.getDescription());
        return teamRepository.save(teamToUpdate);
    }

    @Override
    public List<Team> findAllTeams(PageRequestTest pageRequestTest) {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public void deleteTeamById(@NotNull Integer id) {
        teamRepository.deleteById(id);
    }
}
