package com.example.javapentalog.SecondModule.web.rest;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.repository.competitors.Competitor;
import com.example.javapentalog.SecondModule.repository.matches.Match;
import com.example.javapentalog.SecondModule.repository.teams.Team;
import com.example.javapentalog.SecondModule.services.impl.CompetitorServiceImpl;
import com.example.javapentalog.SecondModule.services.impl.MatchServiceImpl;
import com.example.javapentalog.SecondModule.services.impl.TeamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class ThymeleafController {

    private final CompetitorServiceImpl competitorService;

    private final MatchServiceImpl matchService;

    private final TeamServiceImpl teamService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        PageRequestTest pageRequest = new PageRequestTest(0,20);
        model.addAttribute("competitors",competitorService.findAllCompetitors(pageRequest));
        return "index";
    }

    @GetMapping(value = "deletecomp/{id}")
    public String deleteCompetitor(@PathVariable(value = "id") Integer id){
        competitorService.deleteCompetitorById(id);
        return "redirect:/";
    }

    @GetMapping(value = "updatecomp/{id}")
    public String updateCompetitor(@PathVariable(value = "id") Integer id, Model model){
        Competitor competitor = competitorService.getCompetitorById(id);
        model.addAttribute("competitors",competitor);
        return "update";
    }

    @GetMapping("/addnew")
    public String addNewCompetitor(Model model) {
        Competitor competitor = new Competitor();
        model.addAttribute("competitors", competitor);
        return "create";
    }

    @GetMapping("/addnewteam")
    public String addNewTeam(Model model){
        Team team = new Team();
        model.addAttribute("teams",team);
        return "createteam";
    }

    @PostMapping("/addteam")
    public String addTeam(@ModelAttribute("teams")Team team){
        teamService.save(team);
        return "redirect:/";
    }

    @GetMapping("/addnewmatch")
    public String addNewMatch(Model model){
        Match match = new Match();
        model.addAttribute("matches",match);
        return "creatematch";
    }

    @PostMapping("/savecomp")
    public String addCompetitor(@ModelAttribute("competitors") Competitor competitor) {
        competitorService.save(competitor);
        return "redirect:/";
    }

    @PostMapping("/addmatch")
    public String addMatch(@ModelAttribute("matches")Match match){
        matchService.save(match);
        return "redirect:/";
    }

    @PostMapping("/save/{id}")
    public String saveCompetitor(@ModelAttribute("competitors") Competitor competitor, @PathVariable(value = "id") Integer id) {
        competitorService.patchCompetitorById(id, competitor);
        return "redirect:/";
    }

}
