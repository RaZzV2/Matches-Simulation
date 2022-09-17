package com.example.javapentalog.SecondModule.services;

import com.example.javapentalog.SecondModule.repository.teams.Team;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TeamService {
    Team addTeam(@Valid Team team);

    Team getTeamById(@NotNull Integer id);

    Team getTeamByName(@NotNull String name);

    Team updateTeamById(@NotNull Integer id, @Valid Team team);

    Team patchTeamById(@NotNull Integer id, @Valid Team team);

    List<Team> findAllTeams();

    void deleteTeamById(@NotNull Integer id);
}
