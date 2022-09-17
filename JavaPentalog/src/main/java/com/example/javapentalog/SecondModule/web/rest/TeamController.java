package com.example.javapentalog.SecondModule.web.rest;

import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor

public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity createTeam(@RequestBody Team team){
        final Team addedTeam = teamService.addTeam(team);
        return ResponseEntity.created(URI.create("/api/v1/teams/" + addedTeam.getId())).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Team> getTeam (@PathVariable final Integer id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>>getAllTeams(){
        List<Team> teams = teamService.findAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/after/{name}")
    public ResponseEntity<Team> getTeam (@PathVariable final String name) {
        return ResponseEntity.ok(teamService.getTeamByName(name));
    }

    @PutMapping(value = "/{id}")
    public Team updateTeam (@PathVariable final Integer id,@RequestBody Team team) {
        return teamService.updateTeamById(id, team);
    }

    @PatchMapping(value = "/{id}")
    public Team patchTeam (@PathVariable final Integer id,@RequestBody Team team) {

        return teamService.patchTeamById(id, team);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTeam (@PathVariable final Integer id) {
       teamService.deleteTeamById(id);
    }
}
