package com.example.javapentalog.SecondModule.web;

import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.services.CompetitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/competitors")
@RequiredArgsConstructor

public class CompetitorController {

    private final CompetitorService competitorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Competitor> getCompetitor (@PathVariable final Integer id) {

        return ResponseEntity.ok(competitorService.getCompetitorById(id));
    }

    /*@GetMapping("/all")
    public ResponseEntity<List<Competitor>>getAllCompetitors(){
        List<Competitor> competitors = competitorService.findAllCompetitors();
        return ResponseEntity.ok(competitors);
    }*/

    @GetMapping("/after/{name}")
    public ResponseEntity<Competitor> getCompetitor (@PathVariable final String name) {

        return ResponseEntity.ok(competitorService.getCompetitorByName(name));
    }

    @PostMapping
    public ResponseEntity createCompetitor (@RequestBody Competitor competitor) {

        final Competitor addedCompetitor = competitorService.addCompetitor(competitor);
        return ResponseEntity.created(URI.create("/api/v1/competitors/" + addedCompetitor.getId())).build();
    }

    @PutMapping(value = "/updatecomp/{id}")
    public Competitor updateCompetitor (@PathVariable final Integer id,@RequestBody Competitor competitor) {

        return competitorService.updateCompetitorById(id, competitor);
    }


    @PatchMapping(value = "/{id}")
    public Competitor patchCompetitor (@PathVariable final Integer id,@RequestBody Competitor competitor) {

        return competitorService.patchCompetitorById(id, competitor);
    }

    @DeleteMapping(value = "/deletecomp/{id}")
    public void deleteCompetitor (@PathVariable final Integer id) {

       competitorService.deleteCompetitorById(id);
    }

}
