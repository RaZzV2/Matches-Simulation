package com.example.javapentalog.SecondModule;

import com.example.javapentalog.SecondModule.repository.matchteams.MatchTeam;

public class PlannedMatch {
    private MatchTeam firstMatchTeam;
    private MatchTeam secondMatchTeam;

    public PlannedMatch(MatchTeam firstMatchTeam, MatchTeam secondMatchTeam) {
        this.firstMatchTeam = firstMatchTeam;
        this.secondMatchTeam = secondMatchTeam;
    }

    public MatchTeam getFirstMatchTeam() {
        return firstMatchTeam;
    }

    public void setFirstMatchTeam(MatchTeam firstMatchTeam) {
        this.firstMatchTeam = firstMatchTeam;
    }

    public MatchTeam getSecondMatchTeam() {
        return secondMatchTeam;
    }

    public void setSecondMatchTeam(MatchTeam secondMatchTeam) {
        this.secondMatchTeam = secondMatchTeam;
    }
}
