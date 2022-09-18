package com.example.javapentalog.SecondModule.web;

import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@RequiredArgsConstructor

public class MatchController {
    private final MatchService matchService;

    @PostMapping
    public ResponseEntity createMatch(@RequestBody Match match){
        final Match addedMatch = matchService.addMatch(match);
        return ResponseEntity.created(URI.create("/api/v1/matches/" + addedMatch.getId())).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> getMatch (@PathVariable final Integer id) {

        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Match>>getAllMatches(){
        List<Match> matches = matchService.findAllMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/after/{name}")
    public ResponseEntity<Match> getMatch (@PathVariable final String name) {

        return ResponseEntity.ok(matchService.getMatchByName(name));
    }

    @PutMapping(value = "/{id}")
    public Match updateMatch (@PathVariable final Integer id,@RequestBody Match match) {

        return matchService.updateMatchById(id, match);
    }


    @PatchMapping(value = "/{id}")
    public Match patchMatch (@PathVariable final Integer id,@RequestBody Match match) {

        return matchService.patchMatchById(id, match);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMatch (@PathVariable final Integer id) {

        matchService.deleteMatchById(id);
    }
}
