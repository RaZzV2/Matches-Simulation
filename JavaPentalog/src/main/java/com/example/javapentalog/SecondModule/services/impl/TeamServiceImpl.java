package com.example.javapentalog.SecondModule.services.impl;

import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.competitors.CompetitorRepository;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.matches.MatchRepository;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.repository.teams.TeamRepository;
import com.example.javapentalog.SecondModule.services.TeamService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @Override
    public Team addMatchToTeam(String teamName, String matchName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow(() -> new RuntimeException("Team not found"));
        Match actualMatch = matchRepository.findByMatchName(matchName).orElseThrow(() -> new RuntimeException("Match not found"));
        List<Match> matches = actualTeam.getMatches();
        if(!matches.contains(actualMatch))
            matches.add(actualMatch);
        //else throw
        actualTeam.setMatches(matches);
        return teamRepository.save(actualTeam);
    }

    @Override
    public Team removeMatchFromTeam(String teamName, String matchName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow(() -> new RuntimeException("Team not found"));
        Match actualMatch = matchRepository.findByMatchName(matchName).orElseThrow(() -> new RuntimeException("Match not found"));
        List<Match> matches = actualTeam.getMatches();
        matches.remove(actualMatch);
        actualTeam.setMatches(matches);
        return teamRepository.save(actualTeam);
    }

    @Override
    public Team addCompetitorToTeam(String teamName, String competitorName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow( () -> new RuntimeException("Team not found"));
        Competitor actualCompetitor = competitorRepository.findByName(competitorName).orElseThrow( () -> new RuntimeException("Competitor not found"));
        List<Competitor> myList = actualTeam.getCompetitors();
        myList.add(actualCompetitor);
        actualTeam.setCompetitors(myList);
        return teamRepository.save(actualTeam);
    }
    @Override
    public Team removeCompetitorFromTeam(String teamName, String competitorName) {
        Team actualTeam = teamRepository.findByTeamName(teamName).orElseThrow( () -> new RuntimeException("Team not found"));
        Competitor actualCompetitor = competitorRepository.findByName(competitorName).orElseThrow( () -> new RuntimeException("Competitor not found"));
        List<Competitor> myList = actualTeam.getCompetitors();
        myList.remove(actualCompetitor);
        actualTeam.setCompetitors(myList);
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
        teamToUpdate.setTeamName(team.getTeamName());
        teamToUpdate.setCompetitors(team.getCompetitors());
        teamToUpdate.setMatches(team.getMatches());
        teamToUpdate.setDescription(team.getDescription());
        return teamRepository.save(team);
    }

    @Override
    public Team patchTeamById(@NotNull Integer id, @Valid Team team) {
        Team teamToUpdate = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        if(teamToUpdate.getTeamName() != null)
            teamToUpdate.setTeamName(team.getTeamName());
        if(teamToUpdate.getCompetitors() != null)
            teamToUpdate.setCompetitors(team.getCompetitors());
        if(teamToUpdate.getMatches() != null)
            teamToUpdate.setMatches(team.getMatches());
        if(teamToUpdate.getDescription() != null)
            teamToUpdate.setDescription(team.getDescription());
        return teamRepository.save(teamToUpdate);
    }

    @Override
    public List<Team> findAllTeams() {
        return (List<Team>)teamRepository.findAll();
    }

    @Override
    public void deleteTeamById(@NotNull Integer id) {
        teamRepository.deleteById(id);
    }
}
